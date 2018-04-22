package com.cmsc508.db508project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;
import java.sql.SQLException;

public class tableView extends AppCompatActivity {

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
    }


}
