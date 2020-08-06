package com.svecw.projectregistration;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentLogin extends AppCompatActivity {

    EditText teamname, password;
    Button b;
    TextView s;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_login);

        teamname = (EditText) findViewById(R.id.studentteam);
        password = (EditText)findViewById(R.id.studentpassword);
        b = findViewById(R.id.studentlogin);
        s = findViewById(R.id.statuss);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final FirebaseDatabase database = FirebaseDatabase.getInstance();
                final DatabaseReference databaseReference = database.getReference("Student");

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (databaseReference.child(teamname.getText().toString()) != null) {
                            DataSnapshot ds = dataSnapshot.child(teamname.getText().toString());
                            if (ds.child("password").getValue().toString().contentEquals(password.getText().toString())) {
                                Intent intent = new Intent(getApplicationContext(), StudentHome.class);
                                intent.putExtra("team name", teamname.getText().toString());
                                startActivity(intent);
                            }
                            else {
                                s.setText("Invalid Credentials..");
                            }

                        }
                        else {
                            s.setText("Invalid Credentials..");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



            }
        });
    }
}
