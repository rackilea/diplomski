public class classname extends Activity implements OnItemSelectedListener {

    ListView lv;
     ArrayList<x_obj> new_al=new ArrayList<x_obj>();
     ArrayList<x_obj> x_list = new ArrayList<x_obj>();
      TextView  delete;
   @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_x);
  del_txt = (TextView) findViewById(R.id.del_txt);

   del_txt.setOnClickListener(new OnClickListener()
{
    @Override
    public void onClick(View v)
    {
       "code for delete selected items"

    }
});
        }
          public OrderAdapter(Context context, int row_layout,
        ArrayList<x_obj> items) {
    super(context, row_layout, items);
    this.items = items;
}

@Override
public View getView(final int position, View convertview, ViewGroup parent) {
    View v = convertview;

    LayoutInflater vi = (LayoutInflater)                    
           getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    v = vi.inflate(R.layout.row_layout, null);
    final x obj = items.get(position);

      TextView txt_name = (TextView) v.findViewById(R.id.txt_name);
         CheckBox checkBox1=(CheckBox)findViewById(R.id.checkBox1);
             if(checkBox1.isChecked())
           {
           new_al.add(x_list.get(position));//add the element into arraylist

                }  
                 btn_clear.setOnItemClickListener(new Listener()
              {

            public void onClick(View v)
             {

             x_list.clear();
             x_list.add(new_al);
           }
            }
               );
              notifyDataSetChanged();
            return v;

              }
                  }