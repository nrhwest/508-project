package com.cmsc508.db508project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText firstNameET;
    String firstName, lastName, nameID, email, schoolDistrict, schoolName, training, gradeLevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//EditText
        firstNameET = (EditText) findViewById(R.id.firstNameEditText);
        final EditText lastNameET = (EditText) findViewById(R.id.lastNameEditText);
        final EditText idET = (EditText) findViewById(R.id.IDEditText);
        final EditText emailET = (EditText) findViewById(R.id.emailEditText);
        final EditText schoolDistrictET = (EditText) findViewById(R.id.schoolDistrictEditText);
        final EditText schoolET = (EditText) findViewById(R.id.schoolEditText);
        final EditText trainingET = (EditText) findViewById(R.id.trainingEditText);
        final EditText gradeLevelET = (EditText) findViewById(R.id.gradeLevelEditText);


//Button
        Button Search = (Button) findViewById(R.id.searchButton);

 //Switching views
        Search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Retrieving data from editText
                firstName = firstNameET.getText().toString();
                lastName = lastNameET.getText().toString();
                nameID = idET.getText().toString();
                email = emailET.getText().toString();
                schoolDistrict = schoolDistrictET.getText().toString();
                schoolName = schoolET.getText().toString();
                training = trainingET.getText().toString();
                gradeLevel = gradeLevelET.getText().toString();

                Intent startIntent = new Intent(MainActivity.this, tableView.class);
                System.out.println("MAIN FIRST NAME IS " + firstName);

                if(firstNameET.getText().toString().trim().length() > 0){
                startIntent.putExtra("firstName", firstName);
                }

                if(lastNameET.getText().toString().trim().length() > 0) {
                    startIntent.putExtra("lastName", lastName);
                }

                if(idET.getText().toString().trim().length() > 0) {
                    startIntent.putExtra("ID", nameID);
                }

                if(emailET.getText().toString().trim().length() > 0) {
                    startIntent.putExtra("email", email);
                }

                if(schoolDistrictET.getText().toString().trim().length() > 0) {
                    startIntent.putExtra("schoolDistrict", schoolDistrict);
                }

                if(schoolET.getText().toString().trim().length() > 0) {
                    startIntent.putExtra("schoolName", schoolName);
                }

                if(trainingET.getText().toString().trim().length() > 0) {
                    startIntent.putExtra("training", training);
                }

                if(gradeLevelET.getText().toString().trim().length() > 0) {
                    startIntent.putExtra("gradeLevel", gradeLevel);
                }

                startActivity(startIntent);
            }
        });

    }


}
