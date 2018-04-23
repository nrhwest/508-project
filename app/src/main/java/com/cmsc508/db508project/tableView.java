package com.cmsc508.db508project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class tableView extends AppCompatActivity {

    Cursor cursor;
    String query;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_view);
        list = (ListView) findViewById(R.id.displayList);

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

        //Bundle extras = getIntent().getExtras();
        //String firstName;

//        if (!extras.isEmpty()) {
//            firstName = extras.getString("firstName");
//        }

        String firstName = getIntent().getStringExtra("firstName");
        String lastName = getIntent().getStringExtra("lastName");
        String nameID = getIntent().getStringExtra("ID");
        String email = getIntent().getStringExtra("email");
        String schoolDistrict = getIntent().getStringExtra("schoolDistrict");
        String schoolName = getIntent().getStringExtra("schoolName");
        String training = getIntent().getStringExtra("training");
        String gradeLevel = getIntent().getStringExtra("gradeLevel");

<<<<<<< HEAD
        System.out.println("FIRST NAME IS " + firstName);
=======
        if (firstName.length() > 0) {
            query = "select * from teacher where firstName = " + firstName + "' ;";
        }


        Teacher teacher = new Teacher();

>>>>>>> 8f60c36ca8e208a4c51edd9561de916cc03f18ad

        if (firstName.length() > 0){
            query = String.format("Select * from teacher where firstName = '" + firstName + "';");
        }



        SQLiteDatabase database = db.getWritableDatabase();
<<<<<<< HEAD
=======

>>>>>>> 8f60c36ca8e208a4c51edd9561de916cc03f18ad
        cursor = database.rawQuery(query, null);
<<<<<<< HEAD
        ArrayList<String> teacherArray = new ArrayList<String>();


=======
        
>>>>>>> cd2b0dddfe47197874e55fb52bb1b2f3ccb3533e

<<<<<<< HEAD

//        StringBuffer buffer = new StringBuffer();
//        while(cursor.moveToNext()){
//            buffer.append("Name: " + cursor.getString(0)+ "\n");
//            buffer.append("Ni" + cursor.getString(1)+ "\n");
//        }
//        showMessage("Query", buffer.toString());
=======
        StringBuffer buffer = new StringBuffer();
        while(cursor.moveToNext()){
            buffer.append(cursor.getString(0)+ "\n");
            cursor.

        }

       showMessage("Query", buffer.toString());
>>>>>>> 8f60c36ca8e208a4c51edd9561de916cc03f18ad

    }

//    public void showMessage(String title, String Message){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setTitle(title);
//        builder.setMessage(Message);
//        builder.show();
//    }

}
