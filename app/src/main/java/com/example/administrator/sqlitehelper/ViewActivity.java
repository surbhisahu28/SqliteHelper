package com.example.administrator.sqlitehelper;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Administrator on 3/30/2017.
 */
public class ViewActivity extends Activity {
    private EditText editTextId;
    private EditText editTextName;
    private EditText editTextAdd;
    private Button btnShow;
    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewxml);
        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAdd = (EditText) findViewById(R.id.editTextAddress);

        btnShow = (Button) findViewById(R.id.btnShow);

        db = new DatabaseHelper(this);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showdetail(Integer.parseInt(editTextId.getText().toString()));
            }
        });
    }

    private void showdetail(int id) {
        Cursor c=db.getPerson(id);
        c.moveToNext();
        if(c!=null){
            editTextId.setText(c.getString(c.getColumnIndex(DatabaseHelper.COLUMN_ID)));
            editTextName.setText(c.getString(c.getColumnIndex(DatabaseHelper.COLUMN_NAME)));
            editTextAdd.setText(c.getString(c.getColumnIndex(DatabaseHelper.COLUMN_ADD)));
        }
    }
}
