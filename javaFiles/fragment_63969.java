public class MainActivity extends Activity {


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ListView ll = (ListView) findViewById(R.id.list);
    CustomAdapter cus = new CustomAdapter();
    ll.setAdapter(cus);

}

class CustomAdapter extends BaseAdapter
{
    LayoutInflater mInflater;


    public CustomAdapter()
    {
        mInflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 30;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final ViewHolder vh;
        vh= new ViewHolder();

        if(convertView==null )
         {
            convertView=mInflater.inflate(R.layout.row, parent,false);

            vh.tv2= (TextView)convertView.findViewById(R.id.textView2);
            vh.tv1= (TextView)convertView.findViewById(R.id.textView2);


         }
        else
        {
         convertView.setTag(vh);
        }
            vh.tv1.setText("my text");
            vh.tv2.setText("Postion = "+position);  
        return convertView;
    }

 class ViewHolder
 {
    TextView tv1,tv2;
 }  
 }
}