GetXMLTask(MyActivity activity)
{
    this.mActivity = new WeakReference<MyActivity>(activity);
}

protected void onPostExecute(MyData result)
{
     MyActivity activity = this.mActivity.get();
     if (activity == null) // Activity was destroyed due to orientation change, etc.
         return;
     activity.updateUiFromXml(result);
 }