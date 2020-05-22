public class myAsyncTaskextends AsyncTask<Void, Void, Void> 
{
    private ArrayList<MyObjectMap> myList; 
    private BaseAdapter baseAdapter;
    private int position;

    public myAsyncTask(ArrayList myList, int position, BaseAdapter baseAdapter) {
         this.myList = myList;
         this.position = position;
         this.baseAdapter = baseAdapter;
    }

    protected void onPreExecute() 
    { 

    } 


    @Override 
    protected Void doInBackground(Void... voids) 
    {
        myList.get(position).updateThisItem(); //or 

        /*    
        MyObjectMap mop = myList.get(position);
        mop.updateThisItem();

        myList.remove(position);
        myList.add(position, mop);
        */
        return null; 
    } 

    protected void onPostExecute() 
    {
        baseAdapter.notifyDataSetChanged();
    }
}