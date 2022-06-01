package com.example.listviewadduser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DBHandler mydb;
    DataModel usermodel;
    Button bttopg2, btadduser;
    EditText etname, etpass;
    TextView tvname, tvpass;
    private View.OnClickListener myClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.buttontopg2:
                    goToActivity2();
                    break;
                case R.id.buttonadduser:
                    //addUser();
                    cobakeluar();
                    break;
            }
        }
    };

    private void goToActivity2() {
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }
    private void cobakeluar(){
        String dbname = etname.getText().toString();
        tvname.setText(dbname);
        String dbpass = etpass.getText().toString();
        tvpass.setText(dbpass);
        usermodel = new DataModel(1, dbname, dbpass);
        mydb.insertUser(usermodel);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DBHandler(this);
        bttopg2 = findViewById(R.id.buttontopg2);
        bttopg2.setOnClickListener(myClickListener);
        btadduser = findViewById(R.id.buttonadduser);
        btadduser.setOnClickListener(myClickListener);
        tvname = (TextView) findViewById(R.id.textViewnama);
        tvpass = (TextView) findViewById(R.id.textViewpass);
        etname = findViewById(R.id.editTextTextPersonName);
        etpass = findViewById(R.id.editTextTextPassword);
    }

}