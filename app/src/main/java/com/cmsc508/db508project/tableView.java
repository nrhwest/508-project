package com.cmsc508.db508project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;
import java.sql.SQLException;

public class tableView extends AppCompatActivity {

    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_view);

        DatabaseHelper db = new DatabaseHelper(this);

        try {
            db.createDataBase();
            Toast.makeText(tableView.this, "Database created", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {

            e.printStackTrace();
        }

        try {
            db.openDataBase();
            Toast.makeText(tableView.this, "Database opened", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        SQLiteDatabase database = db.getWritableDatabase();
        String query = "select firstName from teacher";
        cursor = database.rawQuery(query, null);

        StringBuffer buffer = new StringBuffer();
        while(cursor.moveToNext()){
            buffer.append("Name " + cursor.getString(0)+ "\n");
        }

        showMessage("Query", buffer.toString());

    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }

}
