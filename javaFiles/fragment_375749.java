package com.example.vta.webview_example;

/*
 * Note that I was a complete novice in Java and Android when I was writting this.
 * Note that I found pieces of code that I adapted for my needs.
 */

import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;


import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

public class MainActivity extends Activity
{
    private static String CLIENT_ID = "your ID_CLIENT code";
    private static String CLIENT_SECRET ="your SECRET_CLIENT code";
    private static String REDIRECT_URI="http://localhost";
    private static String GRANT_TYPE="authorization_code";
    private static String TOKEN_URL ="https://api.misfitwearables.com/auth/tokens/exchange";
    private static String OAUTH_URL ="https://api.misfitwearables.com/auth/dialog/authorize";
    private static String OAUTH_SCOPE="public,birthday,email,tracking,session,sleep";

    WebView                 web;
    Button                  auth;
    SharedPreferences       pref;
    TextView                Access;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getSharedPreferences("AppPref", MODE_PRIVATE);
        Access =(TextView)findViewById(R.id.Access);
        auth = (Button)findViewById(R.id.auth);
        auth.setOnClickListener(new View.OnClickListener()
        {
            Dialog auth_dialog;
            @Override
            public void onClick(View arg0)
            {
                auth_dialog = new Dialog(MainActivity.this);
                auth_dialog.setContentView(R.layout.auth_dialog);
                web = (WebView)auth_dialog.findViewById(R.id.webv);
                web.getSettings().setJavaScriptEnabled(true);
                web.loadUrl(OAUTH_URL+"?redirect_uri="+REDIRECT_URI+"&response_type=code&client_id="+CLIENT_ID+"&scope="+OAUTH_SCOPE);
                web.setWebViewClient(new WebViewClient()
                {
                    boolean     authComplete = false;
                    Intent      resultIntent = new Intent();
                    String      authCode;

                    @Override
                    public void onPageStarted(WebView view, String url, Bitmap favicon)
                    {
                        super.onPageStarted(view, url, favicon);
                    }

                    @Override
                    public void onPageFinished(WebView view, String url)
                    {
                        super.onPageFinished(view, url);

                        if (url.contains("?code=") && authComplete != true)
                        {
                            Uri uri = Uri.parse(url); //Create an uri, identical to the url
                            System.out.println("=====> uri <===== \n" + uri);
                            authCode = uri.getQueryParameter("code"); //Parse the uri to fond the first occurence of "code", and extract his value
                            Log.i("", "CODE : " + authCode);
                            System.out.println("=====> code <===== \n" + authCode);
                            authComplete = true;
                            resultIntent.putExtra("code", authCode);
                            MainActivity.this.setResult(Activity.RESULT_OK, resultIntent);
                            setResult(Activity.RESULT_CANCELED, resultIntent);
                            SharedPreferences.Editor edit = pref.edit();
                            edit.putString("Code", authCode);
                            edit.commit();
                            auth_dialog.dismiss();
                            new TokenGet().execute();
                            Toast.makeText(getApplicationContext(),"Authorization Code is: " +authCode, Toast.LENGTH_SHORT).show();
                        }
                        else if(url.contains("error=access_denied"))
                        {
                            Log.i("", "ACCESS_DENIED_HERE");
                            resultIntent.putExtra("code", authCode);
                            authComplete = true;
                            setResult(Activity.RESULT_CANCELED, resultIntent);
                            Toast.makeText(getApplicationContext(), "Error Occured", Toast.LENGTH_SHORT).show();
                            auth_dialog.dismiss();
                        }
                    }
                });
                auth_dialog.show();
                auth_dialog.setTitle("Authorize Misfit");
                auth_dialog.setCancelable(true);
            }
        });
    }

    private class TokenGet extends AsyncTask<String, String, JSONObject>
    {
        private ProgressDialog pDialog;
        String Code;
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Contacting Misfit ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            Code = pref.getString("Code", "");
            pDialog.show();
        }

        @Override
        protected JSONObject doInBackground(String... args)
        {
            GetAccessToken jParser = new GetAccessToken();
            JSONObject json = jParser.gettoken(TOKEN_URL,Code,CLIENT_ID,CLIENT_SECRET,REDIRECT_URI,GRANT_TYPE);
            System.out.println("=====> json <===== \n" + json);
            return json;
        }

        @Override
        protected void onPostExecute(JSONObject json)
        {
            pDialog.dismiss();
            if (json != null)
            {
                try
                {
                    final String tok = json.getString("access_token");
                    Log.d("Token Access", tok);
                    System.out.println("TOKN = " + tok);
                    auth.setText("Authenticated");
                    Access.setText("Access Token:" + tok);
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
                getRequestToMisfit(json);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Network Error", Toast.LENGTH_SHORT).show();
                pDialog.dismiss();
            }
        }
    }

    public void getRequestToMisfit(JSONObject json)
    {
        try
        {
            URL                     url;
            HttpURLConnection       connection;
            String                  tok;
            InputStream             is;
            BufferedReader          rd;
            String                  line;
            String                  responseStr;
            StringBuffer            response;
            String                  end_date;
            String                  today;
            String                  start_date;
            Context                 context;
            File                    file;
            File                    file_value;
            String                  filepath;
            String                  filepath_value;
            String                  result;

            result = null;
            context = MyApp.getContext();
            connection = null;
            rd = null;
            tok = json.getString("access_token");
            FileManagement fm = new FileManagement();
            Calendar c = Calendar.getInstance();
            String d = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
            String m = String.valueOf((c.get(Calendar.MONTH) + 1));
            String y = String.valueOf(c.get(Calendar.YEAR));
            today = y + "-" + m + "-" + d;
            end_date = new String(today);
            filepath = context.getFilesDir().getPath().toString() + "/sync_date.txt";
            filepath_value = context.getFilesDir().getPath().toString() + "/sync_value.txt";
            file = new File(filepath);
            file_value = new File(filepath_value);

            //IF YOU WANT TO SIMULATE AN OLD SYNC
            //fm.writeToFile("2016-03-28", filepath);

            //If you want to delete file that contain previous synchronisation date
            //fm.deleteFile(file);
            if ((start_date = fm.readFromFile(filepath, file)) == null)
                start_date = new String(today);

            //String dataUrl = "https://api.misfitwearables.com/move/resource/v1/user/me/profile?access_token=" + tok;
            String dataUrl = "https://api.misfitwearables.com/move/resource/v1/user/me/activity/summary?start_date="+start_date+"&end_date="+end_date+"&access_token=" + tok;
            System.out.println("=====> access_token <===== \n" + tok);
            try
            {
                // Create connection
                url = new URL(dataUrl);
                setContentView(R.layout.activity_main);
                TextView wv = (TextView) findViewById(R.id.misfit);
                System.out.println("=====> url <===== \n" + url);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                //if setDoOutput is set to "true", HttpUrlConnection will send POST request.
                connection.setDoOutput(false);
                // Send request
                int status = connection.getResponseCode();
                // Get Response
                if(status >= HttpStatus.SC_BAD_REQUEST)
                    is = connection.getErrorStream();
                else
                    is = connection.getInputStream();
                rd = new BufferedReader(new InputStreamReader(is));
                response = new StringBuffer();
                while ((line = rd.readLine()) != null)
                {
                    System.out.println("line = " + line);
                    response.append(line);
                    response.append('\r');
                }
                rd.close();
                responseStr = response.toString();
                JSONObject json_res = new JSONObject(responseStr);
                System.out.println("JSON_OBJ" + json_res);
                result = json_res.getString("points");
                Log.d("Server response", responseStr);
                System.out.println(responseStr);
                System.out.println(start_date);
                System.out.println(end_date);
                System.out.println(result);
                wv.setText("nombre de point :\ndu " + start_date + " au " + end_date + "\n" + "***   " + result + "   ***");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                if (connection != null)
                    connection.disconnect();
                if (rd != null)
                {
                    try
                    {
                        rd.close();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            if (!file.exists())
            {
                try
                {
                    file.createNewFile();
                    file.mkdir();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            fm.writeToFile(today, filepath);
            if (!file_value.exists())
            {
                try
                {
                    file_value.createNewFile();
                    file_value.mkdir();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            fm.writeToFile(result, filepath_value);
            System.out.println(fm.readFromFile(filepath_value, file));
            Toast.makeText(context, "Result added to file ==> OK", Toast.LENGTH_LONG);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

}