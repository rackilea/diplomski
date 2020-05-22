public YourTask extends AsyncTask<Object,Object,Object>{ 
private OnTaskCompleted listener;

// all your stuff
public YourTask(OnTaskCompleted listener){
    this.listener=listener;
}

protected void onPostExecute(Object o){
    listener.onTaskCompleted(doc);
}
}