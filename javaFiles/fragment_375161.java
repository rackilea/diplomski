private OnAsyncFinished onAsyncFinished;
public UpdateProfile(..., OnAsyncFinished onAsyncFinished) {
   ...
   this.onAsyncFinished = onAsyncFinished;
}
...
@Override
protected void onPostExecute(String s) {
    super.onPostExecute(s);
    onAsyncFinished.onAsyncFinished(s); //This will notifiy the method on main activity, and you can now resume the work there
    ...
}