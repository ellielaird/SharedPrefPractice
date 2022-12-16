package com.example.sharedprefpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();

        Address address = new Address("Germany", "Berlin");

        ArrayList<FamilyMember> family = new ArrayList<FamilyMember>();
        family.add(new FamilyMember("wife", 13));
        family.add(new FamilyMember("daughter", 5));

        Employee employee = new Employee("John", 30, "john@gmail.com", address, family);

        String json = gson.toJson(employee);
        String json2 = gson.toJson(family);

        Employee employee2 = gson.fromJson(json, Employee.class);

        Type familyType = new TypeToken<ArrayList<FamilyMember>>(){}.getType();
        ArrayList<FamilyMember> family2 = gson.fromJson(json2, familyType );
        // Retrieving the value using its keys the file name
// must be same in both saving and retrieving the data
        SharedPreferences sh = getSharedPreferences("SharedPrefPractice", MODE_PRIVATE);

// The value will be default as empty string because for
// the very first time when the app is opened, there is nothing to show
        String s1 = sh.getString("name", "");
        int a = sh.getInt("age", 0);
        boolean e = sh.getBoolean("enrolled", false);

        EditText name = (EditText)findViewById(R.id.textView);
        EditText age = (EditText)findViewById(R.id.textView2);
        CheckBox enrolled = (CheckBox) findViewById(R.id.checkBox);
// We can then use the data
        name.setText(s1);
        age.setText(String.valueOf(a));
        enrolled.setChecked(e);


    }

    public void save(View v){
        SharedPreferences sh = getSharedPreferences("SharedPrefPractice", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sh.edit();

        EditText name = (EditText)findViewById(R.id.textView);
        EditText age = (EditText)findViewById(R.id.textView2);
        CheckBox enrolled = (CheckBox) findViewById(R.id.checkBox);

        myEdit.putString("name", name.getText().toString());
        myEdit.putInt("age", Integer.parseInt(age.getText().toString()));
        myEdit.putBoolean("enrolled", enrolled.isChecked());
                myEdit.apply();

    }

}