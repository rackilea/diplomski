package com.attiq.testapp;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main5Activity extends AppCompatActivity implements Spinner.OnItemSelectedListener {
private Spinner spinner;
private ArrayList<String> students;

//JSON Array
private JSONArray result;

private TextView textViewName;
private TextView textViewCourse;
private TextView textViewSession;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main5);

    //Initializing the ArrayList
    students = new ArrayList<String>();

    spinner = findViewById(R.id.spinner);
    spinner.setOnItemSelectedListener(this);

    textViewName = findViewById(R.id.textViewName);
    textViewCourse = findViewById(R.id.textViewCourse);
    textViewSession = findViewById(R.id.textViewSession);

    getData();
}

private void getData(){
    String json= "{\"result\":[{\"username\":\"haha\",\"name\":\"Bus Bisnis\",\"course\":\"math\",\"session\":\"20119\"},{\"username\":\"hihi\",\"name\":\"Bus Ace\",\"course\":\"fizik\",\"session\":\"12817\"},{\"username\":\"m_ridwan\",\"name\":\"Ridwan\",\"course\":\"Komputer\",\"session\":\"1920\"},{\"username\":\"m_iqbal\",\"name\":\"Iqbal\",\"course\":\"Sains\",\"session\":\"2021\"}]}";
    try {
        JSONObject jsonObject = new JSONObject(json);
        result= jsonObject.getJSONArray("result");
        getStudents(result);
    } catch (Exception e){
        e.printStackTrace();
    }
}

private void getStudents(JSONArray j) {
    for (int i = 0; i < j.length(); i++) {
        try {
            JSONObject json = j.getJSONObject(i);

            students.add(json.getString(Config.TAG_USERNAME));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, students));
}

private String getName(int position) {
    String name = "";
    try {

        JSONObject json = result.getJSONObject(position);

        name = json.getString(Config.TAG_NAME);
    } catch (JSONException e) {
        e.printStackTrace();
    }
    return name;
}

private String getCourse(int position) {
    String course = "";
    try {
        JSONObject json = result.getJSONObject(position);
        course = json.getString(Config.TAG_COURSE);
    } catch (JSONException e) {
        e.printStackTrace();
    }
    return course;
}

private String getSession(int position) {
    String session = "";
    try {
        JSONObject json = result.getJSONObject(position);
        session = json.getString(Config.TAG_SESSION);
    } catch (JSONException e) {
        e.printStackTrace();
    }
    return session;
}

@Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    //Setting the values to textviews for a selected item
    textViewName.setText(getName(position));
    textViewCourse.setText(getCourse(position));
    textViewSession.setText(getSession(position));
}

@Override
public void onNothingSelected(AdapterView<?> parent) {
    textViewName.setText("");
    textViewCourse.setText("");
    textViewSession.setText("");
}
}