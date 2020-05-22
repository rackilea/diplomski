public class MyAdapter extends BaseAdapter{
       private LayoutInflater inflater;
       private List<String> data;
       public MyAdapter(Context context, List<String> data){
              this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
              this.data = data;
       }

       public int getSize(){
              return data.getSize();
       }
       public Object getItem(int position){
            return data.get(position);
       }

       public View getView(View convertView, int position, ViewGroup parent){
              View v = convertView;
              ViewHolder h;
              if(v == null){
                   v = inflater.inflate(R.layout.my_adapter, false);
                   h = new ViewHolder();
                   t.tv = (TextView) v.findViewById(R.id.my_textview);
                   v.setTag();
              }else{
                   h = (ViewHolder) v.getTag();
              }
              String s = (String) getItem(position);
              h.tv.setText(s);
              return v;
       }
       public class ViewHolder{
              TextView tv;
       }

}