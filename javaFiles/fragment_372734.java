public class CustomListAdapter extends BaseAdapter{   
 String [] result;
 Context context;
 int [] imageId;
 private static LayoutInflater inflater=null;

  public CustomListAdapter (Context mContext, String[] NameList, int[] Images) {
    // TODO Auto-generated constructor stub
    result=NameList;
    context=mContext;
    imageId=Images;
    inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
}
@Override
public int getCount() {
    // TODO Auto-generated method stub
    return result.length;
}

@Override
public Object getItem(int position) {
    // TODO Auto-generated method stub
    return position;
}

@Override
public long getItemId(int position) {
    // TODO Auto-generated method stub
    return position;
}

public class Holder
{
    TextView tv;
    ImageView img;
}
@Override
public View getView(final int position, View convertView, ViewGroup parent) {
    // TODO Auto-generated method stub
    Holder holder=new Holder();
    View rowView;       
         rowView = inflater.inflate(R.layout.row_list_item, null);
         holder.tv=(TextView) rowView.findViewById(R.id.textView1);
         holder.img=(ImageView) rowView.findViewById(R.id.imageView1);       
         holder.tv.setText(result[position]);
         holder.img.setImageResource(imageId[position]);         
         rowView.setOnClickListener(new OnClickListener() {            
          @Override
          public void onClick(View v) {
            // TODO Auto-generated method stub
            Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
        }
    });   
    return rowView;
}

}