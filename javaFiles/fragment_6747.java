ListView myListView = (ListView) findViewById(R.id.idOfYourListView)

runOnUiThread(new Runnable() 
{
    @Override
    public void run()
    {
     myListView.setAdapter( arrayAdapter );
    }
});