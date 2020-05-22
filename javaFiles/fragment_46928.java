class getData extends AsyncTask <Void,Void,Boolaen>
{


@Override
protected Void onPreExecute(Void...arg0)
{
    super.onPreExecute();
    //progress dialog invoked here
}

@Override
protected Boolaen doInBackground(Void...arg0)
{
    try{ 
          parseJSON();
          return true;
    }catch(Exception e){
      e.printStackStrace();
    }

    return false;
}
@Override
protected Void onPostExecute(Boolaen result)
{
    super.onPostExecute(result);
    if(result){
      //success
    }else{
      // Failure
    } 

    //UI manipulated here
}

}