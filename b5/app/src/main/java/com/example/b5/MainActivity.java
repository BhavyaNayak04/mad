package com.example.b5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    Button insert, select;
    EditText name, usn, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper (this).getWritableDatabase();
        insert =  findViewById(R.id.insertb);
        select =  findViewById(R.id.retriveb);
        name =  findViewById(R.id.uname);
        usn =  findViewById(R.id.uusn);
        phone =  findViewById(R.id.uphone);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String iname, iusn, iphone;
                iname = name.getText().toString();
                iusn = usn.getText().toString();
                iphone = phone.getText().toString();
                if (iname.equals("") || iusn.equals("") || iphone.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter values to all 3 fields",
                            Toast.LENGTH_SHORT).show();
                } else {
                    ContentValues values = new ContentValues();
                    values.put("name", iname);
                    values.put("usn", iusn);
                    values.put("phone", iphone);
                    db.insert("student", null, values);
                    Toast.makeText(getApplicationContext(),
                            "Inserted",Toast.LENGTH_SHORT).show();

                }
            }

        });
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = db.rawQuery("select * from student", null);
                if (cursor.getCount() <= 0) {
                    Toast.makeText(getApplicationContext(), "No records found",
                            Toast.LENGTH_SHORT).show();
                } else {
                    for (int i = 0; i < cursor.getCount(); i++) {
                        cursor.moveToNext();
                        String s = "";
                        s += "Name:" + cursor.getString(0);
                        s += "USN:" + cursor.getString(1);
                        s += "Phone:" + cursor.getString(2);
                        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                    }
                }
                cursor.close();
            }
        });
    }
}
