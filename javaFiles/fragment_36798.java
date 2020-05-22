@Override
public View getView(int position, View view, ViewGroup parent) {

    final ViewHolder holder;
    RowBean rowBean = data[position];

    if(view == null){
        holder = new ViewHolder();
        view = inflater.inflate(R.layout.all_object_holder, null);
        holder.name = (TextView) view.findViewById(R.id.showText);
        holder.checkBox = (CheckBox) view.findViewById(R.id.checkBox1);
    }else {
        holder = (ViewHolder) view.getTag();
    }
    holder.name.setText(rowBean.getTitle());

    return view;  //change here
}