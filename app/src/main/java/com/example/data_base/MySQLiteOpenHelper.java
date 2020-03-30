package com.example.data_base;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Data_Base";
    private static final int DB_VERSION = 2;

    MySQLiteOpenHelper(Context context){
        super(context, DB_NAME,null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);

    }

    private static void insertPUB(SQLiteDatabase db, String name, String description, int resourceId) {
        ContentValues pubValues = new ContentValues();
        pubValues.put("NAME", name);
        pubValues.put("DESCRIPTION", description);
        pubValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("PUBS", null, pubValues);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            db.execSQL("CREATE TABLE PUBS (" + "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "NAME TEXT, " +
                    "DESCRIPTION TEXT, " +
                    "IMAGE_RESOURCE_ID INTEGER);");
            insertPUB(db, "kafedra", "nice", R.drawable.kafedra);
            insertPUB(db, "pivnaya_zastava", "tasty", R.drawable.zastava);
            insertPUB(db, "stolovaya92", "shit", R.drawable.stolovaya);
        }
//        if (oldVersion == 2){
//            db.update("PUBS", null, null, null);
//        }
    }
}
