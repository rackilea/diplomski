@Override
 protected void onPostExecute(Boolean result)
 {
    super.onPostExecute(result);
    if(result){
        navigateToMainActivity(time);
    }else{
        newp(line,time);
    }
 }