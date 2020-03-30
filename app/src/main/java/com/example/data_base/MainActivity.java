package com.example.data_base;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAdd, btnRead, btnDelete;
    EditText etName, etText, etInt;
    TextView tvInfo;
    SQLiteOpenHelper pubsDatabaseHelper;
    Cursor cursor;
    ArrayList<Pub> pubs;
    ListView pubsList;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

 /*       btnAdd = (Button) findViewById(R.id.btnFirst);
        btnAdd.setOnClickListener(this);

        btnRead = (Button) findViewById(R.id.btnNext);
        btnRead.setOnClickListener(this);

        btnDelete = (Button) findViewById(R.id.btnLast);
        btnDelete.setOnClickListener(this);

        etName = (EditText) findViewById(R.id.etname);
        etText = (EditText) findViewById(R.id.ettext);
        etInt = (EditText) findViewById(R.id.etint);

        tvInfo = (TextView) findViewById(R.id.tvInfo);*/

        pubsDatabaseHelper = new MySQLiteOpenHelper(this);

        pubs = new ArrayList<>();

        try {
            SQLiteDatabase db = pubsDatabaseHelper.getReadableDatabase();
            cursor = db.query ("PUBS", new String[] {"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"}, null, null, null, null, null);
            if (cursor.moveToFirst()){
                do{
                    Pub temp = new Pub(cursor.getString(0),cursor.getString(1),cursor.getInt(2));
                    pubs.add(temp);
                }while (cursor.moveToNext());
            }
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show(); }

        pubsList = (ListView) findViewById(R.id.countriesList);
        MyAdapter pubsAdapter = new MyAdapter(this, R.layout.list_item, pubs);
        pubsList.setAdapter(pubsAdapter);
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                Pub selectedPub = (Pub) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedPub.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        pubsList.setOnItemClickListener(itemListener);
    }

    @Override
    public void onClick(View view) {

    }

   /* public void onClick(View v) {

        // определяем нажатую кнопку
        switch (v.getId()) {
            // Все записи
            case R.id.btnFirst: {
                if (cursor.moveToFirst()) {
                    String nameText = cursor.getString(0);
                    String descriptionText = cursor.getString(1);
                    int photoId = cursor.getInt(2);
                    tvInfo.setText(nameText + " " + descriptionText + " " + photoId);
                    Toast toast = Toast.makeText(this, "ok", Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;
            }
            // Функция
            case R.id.btnNext: {
                if (cursor.moveToNext()) {
                    String nameText = cursor.getString(0);
                    String descriptionText = cursor.getString(1);
                    int photoId = cursor.getInt(2);
                    tvInfo.setText(nameText + " " + descriptionText + " " + photoId);
                    Toast toast = Toast.makeText(this, "ok", Toast.LENGTH_SHORT);
                    toast.show();
                }

                break;
            }
            // Население больше, чем
            case R.id.btnLast:{
                if (cursor.moveToLast()) {
                    String nameText = cursor.getString(0);
                    String descriptionText = cursor.getString(1);
                    int photoId = cursor.getInt(2);
                    tvInfo.setText(nameText + " " + descriptionText + " " + photoId);
                    Toast toast = Toast.makeText(this, "ok", Toast.LENGTH_SHORT);
                    toast.show();
                }

                break;
            }
        }


    }*/


}