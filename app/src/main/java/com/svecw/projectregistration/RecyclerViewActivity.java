package com.svecw.projectregistration;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity implements ClickListener {

    private RecyclerView mRecyclerView;
    private CustomAdapter mAdapter;
    private ArrayList<String> teams;
    private RecyclerView.LayoutManager mLayoutManager;
    ClickListener clicklistener = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recylerview);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new RecyclerViewDecorator(this));
        Bitmap bitmap = getRoundedShape(BitmapFactory.decodeResource(getResources(),R.drawable.images));
        Drawable d = new BitmapDrawable(getResources(), bitmap);
        teams = new ArrayList<>();

        //adding test items to the list
        mAdapter = new CustomAdapter(this, teams);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setClickListener(this);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = database.getReference("Student");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    teams.add(ds.getKey().toString());
                    mAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    public Bitmap getRoundedShape(Bitmap scaleBitmapImage) {
        int targetWidth = (int)getResources().getDimension(R.dimen.profile_pic_size);
        int targetHeight = (int)getResources().getDimension(R.dimen.profile_pic_size);;
        Bitmap targetBitmap = Bitmap.createBitmap(targetWidth,
                targetHeight,Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(targetBitmap);
        Path path = new Path();
        path.addCircle(((float) targetWidth - 1) / 2,
                ((float) targetHeight - 1) / 2,
                (Math.min(((float) targetWidth),
                        ((float) targetHeight)) / 2),
                Path.Direction.CCW);

        canvas.clipPath(path);
        canvas.drawBitmap(scaleBitmapImage,
                new Rect(0, 0, scaleBitmapImage.getWidth(),
                        scaleBitmapImage.getHeight()),
                new Rect(0, 0, targetWidth, targetHeight), null);
        return targetBitmap;
    }

    @Override
    public void itemClicked(View view, int position) {
        String teamval = teams.get(position);
        Intent intent = new Intent(getApplicationContext(), Team.class);
        intent.putExtra("name", teamval);
        startActivity(intent);

    }


}
