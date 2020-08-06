package com.svecw.projectregistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    EditText team_name,l_name,l_reg_no,l_email,l_ph_no,mem1_name,mem1_reg_no,mem1_email,mem1_ph_no,mem2_name,mem2_reg_no,mem2_email,mem2_ph_no,mem3_name,mem3_reg_no,mem3_email,mem3_ph_no,password;
    Button register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        team_name=findViewById(R.id.team_name);
        l_name = findViewById(R.id.l_name);
        l_reg_no=findViewById(R.id.l_reg);
        l_email=findViewById(R.id.l_email);
        l_ph_no=findViewById(R.id.l_ph_num);
        mem1_name=findViewById(R.id.mem1_name);
        mem1_reg_no=findViewById(R.id.mem1_reg);
        mem1_email=findViewById(R.id.mem1_email);
        mem1_ph_no=findViewById(R.id.mem1_ph_num);
        mem2_name=findViewById(R.id.mem2_name);
        mem2_reg_no=findViewById(R.id.mem2_reg);
        mem2_email=findViewById(R.id.mem2_email);
        mem2_ph_no=findViewById(R.id.mem2_ph_num);
        mem3_name=findViewById(R.id.mem3_name);
        mem3_reg_no=findViewById(R.id.mem3_reg);
        mem3_email=findViewById(R.id.mem3_email);
        mem3_ph_no=findViewById(R.id.mem3_ph_num);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register_button);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = database.getReference("Student");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child(team_name.getText().toString()).child("password").setValue(password.getText().toString());
                databaseReference.child(team_name.getText().toString()).child("Team Leader").child("Name").setValue(l_name.getText().toString());
                databaseReference.child(team_name.getText().toString()).child("Team Leader").child("Regd No").setValue(l_reg_no.getText().toString());
                databaseReference.child(team_name.getText().toString()).child("Team Leader").child("Email").setValue(l_email.getText().toString());
                databaseReference.child(team_name.getText().toString()).child("Team Leader").child("Phone").setValue(l_ph_no.getText().toString());

                databaseReference.child(team_name.getText().toString()).child("Member 1").child("Name").setValue(mem1_name.getText().toString());
                databaseReference.child(team_name.getText().toString()).child("Member 1").child("Regd No").setValue(mem1_reg_no.getText().toString());
                databaseReference.child(team_name.getText().toString()).child("Member 1").child("Email").setValue(mem1_email.getText().toString());
                databaseReference.child(team_name.getText().toString()).child("Member 1").child("Phone").setValue(mem1_ph_no.getText().toString());

                databaseReference.child(team_name.getText().toString()).child("Member 2").child("Name").setValue(mem2_name.getText().toString());
                databaseReference.child(team_name.getText().toString()).child("Member 2").child("Regd No").setValue(mem2_reg_no.getText().toString());
                databaseReference.child(team_name.getText().toString()).child("Member 2").child("Email").setValue(mem2_email.getText().toString());
                databaseReference.child(team_name.getText().toString()).child("Member 2").child("Phone").setValue(mem2_ph_no.getText().toString());

                databaseReference.child(team_name.getText().toString()).child("Member 3").child("Name").setValue(mem3_name.getText().toString());
                databaseReference.child(team_name.getText().toString()).child("Member 3").child("Regd No").setValue(mem3_reg_no.getText().toString());
                databaseReference.child(team_name.getText().toString()).child("Member 3").child("Email").setValue(mem3_email.getText().toString());
                databaseReference.child(team_name.getText().toString()).child("Member 3").child("Phone").setValue(mem3_ph_no.getText().toString());

                Toast.makeText(SignUp.this, "Team Registration Success...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);

            }
        });





    }
}


