package com.example.administrator.sqlitehelper;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//import com.example.administrator.sqlitehelper


public class MainActivity extends Activity implements View.OnClickListener{
    private EditText editTextName;
    private EditText editTextAdd;
    private Button btnSave;
    private Button btnView;

    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  singletona.getInstance();
        //https://www.simplifiedcoding.net/sqlite-database-in-android-using-sqliteopenhelper-class/
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAdd = (EditText) findViewById(R.id.editTextAddress);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnView = (Button) findViewById(R.id.btnView);

        db = new DatabaseHelper(this);
        btnSave.setOnClickListener(this);
        btnView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSave:
                insert();
                break;
            case R.id.btnView:
                Intent i=new Intent(MainActivity.this,ViewActivity.class);
                startActivity(i);
                break;

        }

    }

    private void insert() {
        String name=editTextName.getText().toString();
        String address=editTextAdd.getText().toString();
        db.addPerson(name,address);
        Toast.makeText(MainActivity.this,"Inserted",Toast.LENGTH_LONG).show();
    }
}
