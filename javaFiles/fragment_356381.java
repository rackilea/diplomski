package com.test.test;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ScreenOne extends AppCompatActivity {

private static final String URL_LOGIN = "http://YOUT_IP_ADDRESS(save file in xampp/any local server)/login.php";
private static final String URL_SAVE = "http://YOUR_IP_ADDRESS(save file in xampp/any local server)/save.php";
private EditText username;
private EditText password;
private Button login;
Button save;
String name;
String pass;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.screen_one);

    username = (EditText) findViewById(R.id.etUsername);
    password = (EditText) findViewById(R.id.etPassword);

    (login = (Button) findViewById(R.id.bLogin)).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            request();
        }
    });

    (save = (Button) findViewById(R.id.bSave)).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            saveRequest();
        }
    });
}

private void saveRequest() {
    //get string data from edittext field,in your case take from name, email, password.......
    name = username.getText().toString().trim();
    pass = password.getText().toString().trim();

    //show progressdialog while loading data
    final ProgressDialog mDialog = new ProgressDialog(this);
    mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    mDialog.setMessage("Loading...");
    mDialog.show();

    StringRequest request = new StringRequest(Request.Method.POST, URL_SAVE,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    //responce from server, dismiss dialog and print responce in a toast message.
                    mDialog.dismiss();
                    Toast.makeText(ScreenOne.this, response, Toast.LENGTH_LONG).show();
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    mDialog.dismiss();
                    Toast.makeText(ScreenOne.this, "Something went wrong", Toast.LENGTH_LONG).show();
                }
            }){
        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> key = new HashMap<>();
            //map value to match in your php script, update with yours e.g. name,lastname,email.....
            key.put("username", name);
            key.put("password", pass);
            return key;
        }
    };

    NetworkCalls.getInstance().addToRequestQueue(request);
}

private void request() {
    name = username.getText().toString().trim();
    pass = password.getText().toString().trim();
    final ProgressDialog mDialog = new ProgressDialog(this);
    mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    mDialog.setMessage("Loading...");
    mDialog.show();

    StringRequest request = new StringRequest(Request.Method.POST, URL_LOGIN,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    mDialog.dismiss();
                    Toast.makeText(ScreenOne.this, response, Toast.LENGTH_LONG).show();
                    username.setText("");
                    password.setText("");
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    mDialog.dismiss();
                    Toast.makeText(ScreenOne.this, "Something went wrong", Toast.LENGTH_LONG).show();
                }
            }){
        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> key = new HashMap<>();
            //map the username and password to match with the php script so the user can pass his login values here
            key.put("username", name);
            key.put("password", pass);
            return key;
        }
    };

    NetworkCalls.getInstance().addToRequestQueue(request);
 }
}