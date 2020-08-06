package com.svecw.projectregistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AdminLogin extends AppCompatActivity {

    EditText user, pass;
    Button b;
    TextView s;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);

        user = (EditText)findViewById(R.id.adminname);
        pass = (EditText)findViewById(R.id.adminpassword);
        b = findViewById(R.id.adminlogin);
        s = findViewById(R.id.statusa);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.getText().toString().contentEquals("admin") && pass.getText().toString().contentEquals("admin123")) {
                    Intent intent = new Intent(getApplicationContext(), RecyclerViewActivity.class);
                    intent.putExtra("adminname",  user.getText().toString());
                    startActivity(intent);
                }
                else {
                    s.setText("Invalid Credentials..");
                }

            }
        });
    }
}
