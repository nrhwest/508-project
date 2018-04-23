package com.cmsc508.db508project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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

        System.out.println("FIRST NAME IS " + firstName);
        System.out.println("LAST NAME IS " + lastName);
        System.out.println("ID IS " + nameID);
        System.out.println("EMAIL IS " + email);
        System.out.println("schoolDISTRICT NAME IS " + schoolDistrict);
        System.out.println("school NAME IS " + schoolName);
        System.out.println("training NAME IS " + training);
        System.out.println("gradeLevel IS " + gradeLevel);

        Teacher teacher = new Teacher();

        if (firstName.length() > 0) {
            System.out.println("in if");
            query = "select * from teacher where firstName = '" + firstName + "';";
        }

        if (lastName.length() > 0){
            System.out.println("in if 3");
            query = String.format("Select * from teacher where lastName = '" + lastName + "';");
        }

        if (nameID.length() > 0){
            query = String.format("Select * from teacher where nameID = '" + nameID + "';");
        }

        if (email.length() > 0){
            query = String.format("Select * from teacher where email = '" + email + "';");
        }

        if (schoolDistrict.length() > 0){
            query = String.format("Select * from school where schoolDistrict = '" + schoolDistrict + "';");
        }

        if (schoolName.length() > 0){
            query = String.format("Select * from school where schoolName = '" + schoolName + "';");
        }

        if (training.length() > 0){
            query = String.format("Select * from training where training = '" + training + "';");
        }

        if (gradeLevel.length() > 0){
            query = String.format("Select * from training where gradeLevel = '" + gradeLevel + "';");
        }



        if (firstName.length() > 0 && lastName.length() > 0){
            System.out.println("in if 2");
            query = String.format("Select * from teacher where firstName = '" + firstName + "' && lastName = '" + lastName  + "';");
        }

        if (schoolDistrict.length() > 0 && schoolName.length() > 0){
            query = String.format("Select * from school where schoolDistrict = '" + schoolDistrict + "' && schoolName = '" + schoolName  + "';");
        }

        if (training.length() > 0 && gradeLevel.length() > 0){
            query = String.format("Select * from training where training = '" + training + "' && gradeLevel = '" + gradeLevel  + "';");
        }


        SQLiteDatabase database = db.getWritableDatabase();
        System.out.println("Gucci");
        cursor = database.rawQuery(query, null);
        System.out.println("Gucci2");
        ArrayList<String> teacherArray = new ArrayList<String>();



        StringBuffer buffer = new StringBuffer();
        while(cursor.moveToNext()){
            buffer.append("Name: " + cursor.getString(0)+ "\n");
            buffer.append("Ni" + cursor.getString(1)+ "\n");
        }
        showMessage("Query", buffer.toString());

//        StringBuffer buffer = new StringBuffer();
//        while(cursor.moveToNext()){
//            buffer.append(cursor.getString(0)+ "\n");
//
//        }

       //showMessage("Query", buffer.toString());

    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
