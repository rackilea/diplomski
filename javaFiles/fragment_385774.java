@Override
protected void onPostExecute(ArrayList<Article> result)
{
    dialog.dismiss();
    articlesReturned = result;


    if (MainActivity.articlesReturned.size() > 0){
        if(onAsyncResult!=null)
            onAsyncResult.onResultSuccess(result);

        Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_LONG).show();
    }
    else{
        if(onAsyncResult!=null)
            onAsyncResult.onResultFail(1, "Error, Check Network Connection.");

        Toast.makeText(getApplicationContext(), "Error, Check Network Connection.", Toast.LENGTH_LONG).show();
    }

}