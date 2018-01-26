package com.example.newu.planner;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.ContentValues;
import android.content.Context;
import android.widget.Toast;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "taskDB.db";
    private static final String TABLE_TASKS = "tasks";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_SUBTASK = "subtask";
    private static final String COLUMN_TIME = "time";
    private static final String COLUMN_NOTE = "note";
    public static final String COLUMN_TASKNAME = "taskname";

    //We need to pass database information along to superclass
    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table " + TABLE_TASKS + " ("
                + COLUMN_ID + " integer primary key autoincrement not null,"
                + COLUMN_TIME + " text not null,"
                + COLUMN_SUBTASK + " text not null,"
                + COLUMN_NOTE + " text not null,"
                + COLUMN_TASKNAME + " text not null);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);
        //onCreate(db);
    }

    //Add a new row to the database
    public long addTask(TaskType taskType) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_TASKNAME, taskType.getTaskname());
        values.put(COLUMN_SUBTASK, taskType.getSubtask());
        values.put(COLUMN_NOTE, taskType.getNote());
        values.put(COLUMN_TIME, taskType.getTime());

        SQLiteDatabase db = getWritableDatabase();
        long g = db.insert(TABLE_TASKS, null, values);
        db.close();
        return g;
    }

    //Delete a product from the database

    /**
     * The delete button should be the checklist on the left
     */
    public int deleteTask(String id) {
        SQLiteDatabase db = getWritableDatabase();
        String arg[]={id};

        return db.delete(TABLE_TASKS,COLUMN_TASKNAME+"=?",arg);
        //db.execSQL("DELETE FROM " + TABLE_TASKS + " WHERE " + COLUMN_TASKNAME + "=\"" + productName + "\";");
    }


    public Cursor selectData() {
        String clmns[] = {COLUMN_TASKNAME};

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query(TABLE_TASKS, clmns, null, null, null, null, null);
        return cursor;

    }

    public int updateTask(String sub, String not, String tim, String nam) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SUBTASK, sub);
        values.put(COLUMN_NOTE, not);
        values.put(COLUMN_TIME, tim);
        String arg[] = {nam};
        return db.update(TABLE_TASKS, values, COLUMN_TASKNAME + "=?", arg);
    }
}

