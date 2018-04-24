package com.cmsc508.db508project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.sql.SQLException;

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

        String firstName = getIntent().getStringExtra("firstName");
        String lastName = getIntent().getStringExtra("lastName");
        String nameID = getIntent().getStringExtra("ID");
        String email = getIntent().getStringExtra("email");
        String schoolDistrict = getIntent().getStringExtra("schoolDistrict");
        String schoolName = getIntent().getStringExtra("schoolName");
        String training = getIntent().getStringExtra("training");
        String gradeLevel = getIntent().getStringExtra("gradeLevel");
        String location = getIntent().getStringExtra("location");

        System.out.println("FIRST NAME IS " + firstName);
        System.out.println("LAST NAME IS " + lastName);
        System.out.println("ID IS " + nameID);
        System.out.println("EMAIL IS " + email);
        System.out.println("schoolDISTRICT NAME IS " + schoolDistrict);
        System.out.println("school NAME IS " + schoolName);
        System.out.println("training NAME IS " + training);
        System.out.println("gradeLevel IS " + gradeLevel);
        System.out.println("location IS " + location);

        Teacher teacher = new Teacher();

        if (firstName.length() > 0) {
            query = "select * from teacher where firstName = '" + firstName + "';";
        }

        if (lastName.length() > 0){
            query = String.format("Select * from teacher where lastName = '" + lastName + "';");
        }

        if (email.length() > 0){
            query = String.format("Select * from teacher where email = '" + email + "';");
        }

        if (schoolDistrict.length() > 0){
            query = String.format("Select * from school where districtName = '" + schoolDistrict + "';");
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
            query = String.format("Select * from teacher where firstName = '" + firstName + "' AND lastName = '" + lastName  + "';");
        }



        //Query 1
        if (schoolDistrict.length() > 0){
            query = String.format("Select firstName from teacher inner join school using (sID) where districtName = '" + schoolDistrict + "';");
        }

        //Query 2
        if (schoolName.length() > 0){
            query = String.format("Select firstName from teacher where schoolName = '" + schoolName + "';");
        }

        //Query 3
        if (schoolName.length() > 0 && schoolDistrict.length() > 0){
            query = String.format("Select numTeachersSent from school where districtName = '" + schoolDistrict + "' AND schoolName = '" + schoolName  + "';");
        }

        //Query 4
        if (gradeLevel.length() > 0){
            query = String.format("Select firstName, lastName from teacher where gradeLevel = '" + gradeLevel + "';");
        }

        //Query 5
        if (gradeLevel.length() > 0 && schoolDistrict.length() > 0){
            query = String.format("Select workEmail from teacher inner join school using (sID) where gradeLevel = '" + gradeLevel + "' AND districtName = '" + schoolDistrict + "';");
        }

        //Query 6
        if (nameID.length() > 0){
            query = String.format("Select * from teacher where tID = '" + nameID + "';");
        }

        //Query 7
        if (training.length() > 0){
            query = String.format("Select maxCapacity from training where trainingName = '" + training + "';");
        }

        //Query 8
        if(location.length() > 0){
            query = String.format("Select maxCapacity from training where trainingName = '" + training + "';");
        }

        //Query 9
        if(location.length() > 0 && training.length() > 0 ){
            query = String.format("Select trainingDate, sessTime from session natural join training where location = '" + location + "' AND trainingName = '" + training + "';");
        }

        


       // query = String.format("select * from teacher;");
        SQLiteDatabase database = db.getWritableDatabase();
        cursor = database.rawQuery(query, null);
        System.out.println("cursor count = " + cursor.getCount());

        String[] array = new String[cursor.getCount()];
        int i = 0;

        while(cursor.moveToNext()){
            StringBuilder sb = new StringBuilder();
            String temp = "";
            for (int j = 0; j < cursor.getColumnNames().length; j++) {
                temp = String.valueOf(sb.append(cursor.getString(j) + ", ") );
            }
            temp = sb.toString();
                array[i] = temp;
                i++;
        }

        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j]);
        }

        ArrayAdapter<String> adapter  = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
        list.setAdapter(adapter);

    }


}
