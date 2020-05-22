package com.android.widget;

import java.util.ArrayList;
import java.util.List;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.RemoteViews;

public class HelloWidget extends AppWidgetProvider {
 List<Top5> myList;
 Context context; AppWidgetManager appWidgetManager; int[] appWidgetIds;
 @Override
 public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
  this.context=context;
  this.appWidgetIds=appWidgetIds;
  this.appWidgetManager=appWidgetManager;
  start();
  
 }
 
 private class View  {
  RemoteViews remoteViews;
  ComponentName thisWidget;
  
  
 public View(Context context, AppWidgetManager appWidgetManager,String x) {
  
  remoteViews = new RemoteViews(context.getPackageName(), R.layout.main);
  thisWidget = new ComponentName(context, HelloWidget.class);
  remoteViews.setTextViewText(R.id.tp5hausses,x);
  
  appWidgetManager.updateAppWidget(thisWidget, remoteViews);
 }
 } 

 public void start(){
  
  requestData("http://10.0.3.2:8085/BTCRestfullWebServices/market/top5");

}
 
 public void Init2(){
  new View(context, appWidgetManager,myList.get(0).getValeur());
 }
 
private void requestData(String uri) {
MyTask task = new MyTask();
task.execute(uri);
}
private class MyTask extends AsyncTask<String, String, String> {
 
@Override
protected void onPreExecute() {

}

@Override
protected String doInBackground(String... params) {

String content = HttpManager.getData(params[0]);
return content;
}

protected void onPostExecute(String result) {
 myList=new  ArrayList<Top5>();
myList = Top5JSONParser.parseFeed(result);

Init2();
}

}
}