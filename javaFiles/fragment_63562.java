@Override
   protected void onPostExecute(String result)
   {  
            super.onPostExecute(result);    
            articololink = (TextView)findViewById(R.id.content);
            articololink.setText(result);
            mProgressDialog.dismiss();
    }