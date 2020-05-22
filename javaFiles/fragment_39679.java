public class MainActivity extends ListActivity
{

    ListView lstView; 
    ArrayList<HashMap<String,String>> arraylist = new ArrayList<HashMap<String,String>>(); 
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
       super.onCreate(savedInstanceState);

        lstView = getListView();
        lstView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);    
        for(int i=0;i<10;i++)
        {
            HashMap<String,String> map = new HashMap<String,String>();
            map.put("key", "value"+i);
            arraylist.add(map);

        }
        String[] from = { "key" };
        int[] to = { R.id.textView1 };
        SimpleAdapter adapter= new SimpleAdapter(this, arraylist,R.layout.row, from, to);
        setListAdapter(adapter);

    }   

}