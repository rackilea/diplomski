ArrayList<String> name1 = new ArrayList<String>();
ArrayList<String> phno1 = new ArrayList<String>();
ArrayList<String> phno0 = new ArrayList<String>();
MyAdapter ma ;
Button show,add;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    setContentView(R.layout.get);
    getAllCallLogs(this.getContentResolver());
    ListView lv= (ListView) findViewById(R.id.lv);
     ma = new MyAdapter();
    lv.setAdapter(ma);
    lv.setOnItemClickListener(this); 
    lv.setItemsCanFocus(false);
    lv.setTextFilterEnabled(true);
    // adding
    add = (Button) findViewById(R.id.button1);
    add.setOnClickListener(new OnClickListener()
    {

        @Override
        public void onClick(View v) {
              StringBuilder checkedcontacts= new StringBuilder();
            System.out.println(".............."+ma.mCheckStates.size());
            for(int i = 0; i < name1.size(); i++)

                {
                if(ma.mCheckStates.get(i)==true)
                {
                      phno0.add(phno1.get(i).toString()) ;
                     checkedcontacts.append(name1.get(i).toString());
                     checkedcontacts.append("\n");

                }
                else
                {
           System.out.println("..Not Checked......"+name1.get(i).toString());
                }


            }
                Toast.makeText(MainActivity.this, checkedcontacts,1000).show();
                Intent intent = new Intent(new Intent(MainActivity.this,SendMessage.class));
                intent.putStringArrayListExtra("name",phno0);
                startActivity(intent); 

        }       
    });


}

@Override
public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
    // TODO Auto-generated method stub
     ma.toggle(arg2);
}

public  void getAllCallLogs(ContentResolver cr) {

    Cursor phones = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
    while (phones.moveToNext())
    {
      String name=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
      String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
      System.out.println(".................."+phoneNumber); 
      name1.add(name);
      phno1.add(phoneNumber);
    }

    phones.close();
 }
class MyAdapter extends BaseAdapter implements CompoundButton.OnCheckedChangeListener
{  private SparseBooleanArray mCheckStates;
   LayoutInflater mInflater;
    TextView tv1,tv;
    CheckBox cb;
    MyAdapter()
    {
        mCheckStates = new SparseBooleanArray(name1.size());
        mInflater = (LayoutInflater)MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return name1.size();
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi=convertView;
        if(convertView==null)
         vi = mInflater.inflate(R.layout.row, null); 
         TextView tv= (TextView) vi.findViewById(R.id.textView1);
         tv1= (TextView) vi.findViewById(R.id.textView2);
         cb = (CheckBox) vi.findViewById(R.id.checkBox1);
         tv.setText("Name :"+ name1.get(position));
         tv1.setText("Phone No :"+ phno1.get(position));
         cb.setTag(position);
         cb.setChecked(mCheckStates.get(position, false));
         cb.setOnCheckedChangeListener(this);

        return vi;
    }
     public boolean isChecked(int position) {
            return mCheckStates.get(position, false);
        }

        public void setChecked(int position, boolean isChecked) {
            mCheckStates.put(position, isChecked);
        }

        public void toggle(int position) {
            setChecked(position, !isChecked(position));
        }
    @Override
    public void onCheckedChanged(CompoundButton buttonView,
            boolean isChecked) {
        // TODO Auto-generated method stub

         mCheckStates.put((Integer) buttonView.getTag(), isChecked);                 
    }       
}   
}