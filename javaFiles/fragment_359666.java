ListView myListView = new ListView(context);

MyListArrayAdaptapter myAdapter = new MyListArrayAdaptapter(context);

myListView.setAdapter(myAdapter);



public class MyListArrayAdaptapter extends ArrayAdapter<MySingleLineInList> {

    public MyListArrayAdaptapter(Context context){
          super(context, android.R.layout.simple_spinner_item);
    }

    public void addViewToList(MySingleLineInList l){
        add(l);
        notifyDataSetChanged();
    }
}