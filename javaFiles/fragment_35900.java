class CustomAdapter extends BaseAdapter {

private ArrayList<Country> _data;
Context _c;

CustomAdapter(ArrayList<Country> data, Context c) {
    _data = data;
    _c = c;
    Log.d("inside customAdapter", "inside customAdapter constructor...");
}

public int getCount() {
    // TODO Auto-generated method stub
    return _data.size();
}

public Object getItem(int position) {
    // TODO Auto-generated method stub
    return _data.get(position);
}

public long getItemId(int position) {
    // TODO Auto-generated method stub
    return position;
}

public View getView(int position, View convertView, ViewGroup parent) {
    // TODO Auto-generated method stub
    View v = convertView;
    if (v == null) {
        LayoutInflater vi = (LayoutInflater) _c
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = vi.inflate(R.layout.entity_country, null);
    }

    TextView lit_item_name = (TextView) v.findViewById(R.id.lit_item_name);
    TextView lit_item_population = (TextView) v.findViewById(R.id.lit_item_population);
    TextView lit_item_capital = (TextView) v.findViewById(R.id.lit_item_capital);
    TextView lit_item_language = (TextView) v.findViewById(R.id.lit_item_language);
    TextView lit_item_currency = (TextView) v.findViewById(R.id.lit_item_currency);
    ImageView list_item_image = (ImageView) v.findViewById(R.id.list_item_image);

    Log.d("tvcredit==>", " "+lit_item_name.getText().toString());



    final Country tpj = _data.get(position);
    lit_item_name.setText(tpj.name+"");
    lit_item_population.setText(tpj.population+"");
    lit_item_capital.setText(tpj.capital+"");
    lit_item_language.setText(tpj.language+"");
    lit_item_currency.setText(tpj.currentcy+"");

    list_item_image.setImageResource(tpj.image);

    LinearLayout ll_parent=(LinearLayout)v.findViewById(R.id.ll_parent);
    ll_parent.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(_c,tpj.name+"\n"+tpj.capital,Toast.LENGTH_LONG).show();

            //======== code as per your requirement =========
            //Intent intent=new Intent(_c,TargetActivity.class);
            //intent.putExtra("name",tpj.name+"");
            //intent.putExtra("name",tpj.capital+"");
            //_c.startActivity(intent);
        }
    });
    return v;
}}