@Override
public View getView(int position, View view, ViewGroup parent) {
    if(view == null) {
        holder = new Holder();
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.my_adapter, null);
        holder.result = (TextView)view.findViewById(R.id.description);
        holder.value = (TextView)view.findViewById(R.id.value);
        holder.add = (Button)view.findViewById(R.id.add);
        holder.subtract = (Button)view.findViewById(R.id.subtract); 

        view.setTag(holder);
    } else {
        holder = (Holder)view.getTag();
    }       

    myObject = getItem(position);
    holder.result.setText(myObject.result);
    holder.value.setText(myObject.value);
    final TextView tv = holder.result;

    holder.add.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
            tv.setText("bla bla");          
            }           
    });

    return view;
}