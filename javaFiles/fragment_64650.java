public class AsyncXMLParser extends AsyncTask <Void, Integer, ArrayList<ParsedWebData>> { 

    CustomListViewAdapter _adapter;

    Public AsyncXMLParser(CustomListViewAdapter adapter) {
       _adapter = adapter;
    }

   ...

    @Override 
    protected void onPostExecute(ArrayList <ParsedWebData> result) { 
        CustomListViewAdapter customListViewAdapter = new CustomListViewAdapter(getContext(), R.id.listViewNews, result);
        listView.setAdapter(customListViewAdapter); 
    // Or, depending on design
        _adapter.notifyDataSetChanged();
    }
}