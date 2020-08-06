package com.svecw.projectregistration;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentHome extends AppCompatActivity {
    TextView tn, pass, l1, l2, l3, l4, m11, m12, m13, m14, m21, m22, m23, m24, m31, m32, m33, m34;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_home);
        tn = findViewById(R.id.nameview);
        pass =findViewById(R.id.passwordview);
        l1 = findViewById(R.id.lnameview);
        l2 = findViewById(R.id.lregdview);
        l3 = findViewById(R.id.lemailview);
        l4 = findViewById(R.id.lphview);
        m11 = findViewById(R.id.m1nameview);
        m12 = findViewById(R.id.m1regdview);
        m13 = findViewById(R.id.m1emailview);
        m14 = findViewById(R.id.m1phview);
        m21 = findViewById(R.id.m2nameview);
        m22 = findViewById(R.id.m2regdview);
        m23 = findViewById(R.id.m2emailview);
        m24 = findViewById(R.id.m2phview);
        m31 = findViewById(R.id.m3nameview);
        m32 = findViewById(R.id.m3regdview);
        m33 = findViewById(R.id.m3emailview);
        m34 = findViewById(R.id.m3phview);

        final String tname = getIntent().getStringExtra("team name");

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = database.getReference("Student");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    DataSnapshot ds = dataSnapshot.child(tname);
                    tn.setText("Team Name: " + tname);
                    pass.setText("Password: " + ds.child("password").getValue().toString());
                    l1.setText("Name: " + ds.child("Team Leader").child("Name").getValue().toString());
                l2.setText("Register No: " + ds.child("Team Leader").child("Regd No").getValue().toString());
                l3.setText("Email: " + ds.child("Team Leader").child("Email").getValue().toString());
                l4.setText("Phone No: " + ds.child("Team Leader").child("Phone").getValue().toString());

                m11.setText("Name: " + ds.child("Member 1").child("Name").getValue().toString());
                m12.setText("Register No: " + ds.child("Member 1").child("Regd No").getValue().toString());
                m13.setText("Email: " + ds.child("Member 1").child("Email").getValue().toString());
                m14.setText("Phone No: " + ds.child("Member 1").child("Phone").getValue().toString());

                m21.setText("Name: " + ds.child("Member 2").child("Name").getValue().toString());
                m22.setText("Register No: " + ds.child("Member 2").child("Regd No").getValue().toString());
                m23.setText("Email: " + ds.child("Member 2").child("Email").getValue().toString());
                m24.setText("Phone No: " + ds.child("Member 2").child("Phone").getValue().toString());

                m31.setText("Name: " + ds.child("Member 3").child("Name").getValue().toString());
                m32.setText("Register No: " + ds.child("Member 3").child("Regd No").getValue().toString());
                m33.setText("Email: " + ds.child("Member 3").child("Email").getValue().toString());
                m34.setText("Phone No: " + ds.child("Member 3").child("Phone").getValue().toString());



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
