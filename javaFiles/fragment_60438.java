package com.example.littledev.test_v2;
import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
public class Sql_bridge extends AsyncTask<String,Void,String> {
private Activity ctx;
Sql_bridge (Activity ctx)
{
    this.ctx =ctx;
}

@Override
protected void onPostExecute(String result) {

    switch (result) {
        case "Registered":
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
            break;
        case "Login":
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
            if(ctx instanceof Login){
                ((Login)ctx).onLoginSuccess();
            }
            break;
        default:
            Toast.makeText(ctx, "Failed", Toast.LENGTH_LONG).show();
            break;
    }

}
}