package org.xmlrpc;

import org.xmlrpc.android.XMLRPCClient;
import org.xmlrpc.android.XMLRPCException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Test extends Activity {


    String sessionId ="";
    ProgressDialog pd;
    Context mContext;
    EditText username,apikey;
    Button login;


   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.main);
       mContext=Test.this;


       username=(EditText)findViewById(R.id.username);
       apikey=(EditText)findViewById(R.id.apikey);
       login=(Button)findViewById(R.id.login);
   }
   public void checkUser(View v) 
   {
       if(username.getText().toString().equals("") || apikey.getText().toString().equals(""))
       {
           if(username.getText().toString().equals(""))
           {
               username.requestFocus();
           }
           else
           {
               apikey.requestFocus();
           }
           Toast.makeText(mContext, "Please fill this empty field", Toast.LENGTH_LONG).show();
        }
       else
       {
           new DownloadWebPageTask().execute();   
       }
    }

   private class DownloadWebPageTask extends AsyncTask<Void, Integer, Void> {
       @Override
          protected void onPreExecute() 
          {
                pd=ProgressDialog.show(mContext, "", "Please Wait...\nLoading data...", false);
          }
          @Override
          protected void onPostExecute(Void v) 
          {
              if(pd.isShowing())
                    {
                       pd.dismiss();
                    }
            if(sessionId.equals(""))
            {
                Toast.makeText(mContext, "in Correct Details..Please try again", 
                        Toast.LENGTH_LONG).show();
            }
            else
            {
                Utils.sessionId=sessionId;
                startActivity(new Intent(mContext,Dashboard.class));
                finish();   
            }

          }


       @Override
       protected Void doInBackground(Void... arg0) 
       {
           XMLRPCClient client = new XMLRPCClient( "http://192.168.1.237/machinetest/index.php/api/xmlrpc");
           try 
           {
                   sessionId = (String)client.call( "login", username.getText().toString(),
                           apikey.getText().toString());
                   Log.d( "MY_XMLRPC_SUCCESS_SESSION_ID", sessionId);
           }
           catch (XMLRPCException e) 
           {
               Log.d( "APP_INFO ",  "Exception:  " + e.getMessage());
               Log.e( "APP_INFO ",  "Exception:  " + e.toString());
           }     
           return null;
       }
   }
}