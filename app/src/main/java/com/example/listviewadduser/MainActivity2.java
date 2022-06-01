package com.example.listviewadduser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    Button bttopg1;
    ListView mylv;
    DBHandler mydb;
    private View.OnClickListener myClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.buttontopg1:
                    goToActivity1();
                    break;
            }
        }
    };
    private void goToActivity1() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bttopg1 = findViewById(R.id.buttontopg1);
        bttopg1.setOnClickListener(myClickListener);
        mydb = new DBHandler(this);
        List<ArrayList> data = mydb.getAll();

        mylv = (ListView) findViewById(R.id.lvdb);
        CustomAdapter cAdapter = new CustomAdapter(getApplicationContext(), data);
        mylv.setAdapter(cAdapter);
    }
}