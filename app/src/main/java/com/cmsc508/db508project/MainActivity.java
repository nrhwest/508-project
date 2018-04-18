package com.cmsc508.db508project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText firstNameET = (EditText) findViewById(R.id.firstNameEditText);
        EditText lastNameET = (EditText) findViewById(R.id.lastNameEditText);
        EditText idET = (EditText) findViewById(R.id.IDEditText);
        EditText emailET = (EditText) findViewById(R.id.emailEditText);
        EditText schoolDistrictET = (EditText) findViewById(R.id.schoolDistrictEditText);
        EditText schoolET = (EditText) findViewById(R.id.schoolEditText);
        EditText trainingET = (EditText) findViewById(R.id.trainingEditText);

        Spinner nameSpinner = (Spinner) findViewById(R.id.nameSpinner);
        Spinner lastNameSpinner = (Spinner) findViewById(R.id.lastNameSpinner);
        Spinner idSpinner = (Spinner) findViewById(R.id.IDspinner);
        Spinner emailSpinner = (Spinner) findViewById(R.id.emailSpinner);
        Spinner schoolDistrictSpinner = (Spinner) findViewById(R.id.schoolDistrictSpinner);
        Spinner schoolSpinner = (Spinner) findViewById(R.id.schoolSpinner);
        Spinner trainingSpinner = (Spinner) findViewById(R.id.trainingSpinner);

        Button Search = (Button) findViewById(R.id.searchButton);


        ArrayAdapter<String> firstAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.firstName));

        firstAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nameSpinner.setAdapter(firstAdapter);
        lastNameSpinner.setAdapter(firstAdapter);
        idSpinner.setAdapter(firstAdapter);
        emailSpinner.setAdapter(firstAdapter);
        schoolDistrictSpinner.setAdapter(firstAdapter);
        schoolSpinner.setAdapter(firstAdapter);
        trainingSpinner.setAdapter(firstAdapter);

        Search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent (getApplicationContext(), tableClass.class);
                //Shows how to pass information to the second activity
                //startIntent.putExtra("com.davis.quicklauncher.Something", "Hello world!");
                startActivity(startIntent);

            }
        });
    }
}
