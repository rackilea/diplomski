package com.abc.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;


public class GetData_AsyncTask extends AsyncTask<String, Void, String> 
{
String result="";
Context context;
String params[];

String baseDomainURL = "http://192.168.1.109:8080/";
String jspPath;

public GetData_AsyncTask(Context context, String...params)
{
    this.context = context;
    this.params = params;
}


private ProgressDialog progDialog;        

@Override
protected void onPreExecute() 
{
    super.onPreExecute(); 
    //progDialog = ProgressDialog.show(context, "HTTP Request", "please wait.." , true, false);
}


@Override        
protected String doInBackground(String... notneeded) 
{   
    // SELECT JSP
    if(Integer.parseInt(this.params[0])==1)
    {
        jspPath = "abc.jsp";
    }
    else if(Integer.parseInt(this.params[0])==2)
    {
        jspPath = "def.jsp";
    }

    // CREATE HTTP PARAMS
    String httpParameters = "no=" + Integer.parseInt(this.params[1]) + "&name=" + this.params[2];


    // CREATE REQUEST URL
    String requestURL = baseDomainURL + "/" + jspPath + "?" + httpParameters;


    // CHECK INTERNET CONNECTION & MAKE HTTP REQUEST
    if(hasConnection(this.context))
    {
        try 
        {    
            this.result = getDataFromServer1(requestURL);
            //this.result = getDataFromServer2(requestURL);
            //this.result = getDataFromServer3(requestURL);

            Log.e("async", "HTTP Request Successful: Response: "+this.result);
        }

        catch (Exception e) 
        {
            Log.d("async", "in AsyncTask; Error: "+e.getMessage());
            e.printStackTrace();
        }
    }
    return null;
}



@Override        
protected void onPostExecute(String result) 
{

    // POST HTTP REQUEST EXECUTION

    // DISMISS DIALOG
    //progDialog.dismiss();

}    





//CHECK INTERNET CONNECTION
public static boolean hasConnection(Context context) 
{
    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo netInfo = cm.getActiveNetworkInfo();
    if (netInfo != null && netInfo.isConnected()) 
    {
        return true;
    }
    return false;
}



@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
private String getDataFromServer1(String url_arg) 
{
    String result ="";
    try 
    {
        StrictMode.ThreadPolicy policy = new StrictMode.
          ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy); 
        URL url = new URL(url_arg);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        result = readStream(con.getInputStream());
    } catch (Exception e) {
        e.printStackTrace();
    }
    return result;
}

private String readStream(InputStream in) 
{
  BufferedReader reader = null;
  try 
  {
    reader = new BufferedReader(new InputStreamReader(in));
    String line = "";
    String result="";
    while ((line = reader.readLine()) != null) 
    {
     // System.out.println(line);
        result = result+line;
    }
  } 
  catch (IOException e) 
  {
    e.printStackTrace();
  } 
  finally 
  {
    if (reader != null) 
    {
      try 
      {
        reader.close();
      } 
      catch (IOException e) 
      {
        e.printStackTrace();
      }
    }
  }
  return result;
}




private String getDataFromServer2(String url_arg) 
{
    String page = "";
     try 
     {
         URL url = new URL(url_arg);
         BufferedReader in =  new BufferedReader(new InputStreamReader(url.openStream()));

        String inLine;


            while ((inLine = in.readLine()) != null) 
            {
                page += inLine;
            }


        in.close();
     } 

     catch (IOException e) 
     {
            e.printStackTrace();
            Log.d("async","Problem connecting to the server: "+e.getMessage());
            Log.d("async","Problem connecting to the server: "+e.getLocalizedMessage());
            Log.d("async","Problem connecting to the server: "+e.getCause());
            Log.d("async","Problem connecting to the server: "+e.getStackTrace());
     }
     catch (Exception e) 
     {
        e.printStackTrace();
        Log.d("async","Problem connecting to the server: "+e.getMessage());
        Log.d("async","Problem connecting to the server: "+e.getLocalizedMessage());
        Log.d("async","Problem connecting to the server: "+e.getCause());
        Log.d("async","Problem connecting to the server: "+e.getStackTrace());
     }
     return page;
}




private String getDataFromServer3(String url)
{
    URL url2=null;

    try
    {
        url2 = new URL(url);
    }

    catch (MalformedURLException e1)
    {
        e1.printStackTrace();
    }

    URLConnection con=null;

    try
    {
        con = url2.openConnection();
    }

    catch (IOException e1)
    {
      e1.printStackTrace();
      return "";
    }
    catch (Exception e1)
    {
      e1.printStackTrace();
      return "";
    }

    con.setRequestProperty("User-Agent", "Mozilla/5.0");

    Reader r = null;

    try
    {
        r = new InputStreamReader(con.getInputStream());
    }

    catch (IOException e)
    {
      e.printStackTrace();
      return "";
    }
    catch(Exception e)
    {
          e.printStackTrace();
          return "";
    }

    StringBuilder buf = new StringBuilder();

    int ch=0;

    while (true)
    {
        try
        {
            ch = r.read(); 
        }

        catch (NullPointerException e)
        {
          e.printStackTrace();  
          Log.e("HTML Response Error", "NullpointerException:" + e.getMessage());
          return "";
        }
        catch (RuntimeException e)
        {
          e.printStackTrace();
          Log.e("HTML Response Error", "RuntimeException:" + e.getMessage());
          return "";
        }
        catch (IOException e)
        {
          e.printStackTrace();
          Log.e("HTML Response Error", "IOException:" + e.getMessage());
          return "";
        }
        catch(Exception e)
        {
            e.printStackTrace();
            Log.e("HTML Response Error", "Exception:" + e.getMessage());
            return "";
        }

        if (ch < 0)
          break;

        buf.append((char) ch);

    }

    String str = buf.toString();


    Log.d("HTML Response", str);
    return str;
}

}