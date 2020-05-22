public class CustomAarrayAdapter extends ArrayAdapter
{
LayoutInflater mInflater;
List<ClientScanResult> resultList;
public CustomArrayAdapter(Context context, List<ClientScanResult> list)
{
   super(context,0,list);
   resultList = list;
   mInflater = LayoutInflater.from(context);
}

@Override 
public View getView(int position, View convertView, ViewGroup parent) {  
ViewHolder holder; 

if (convertView == null) { 
convertView = mInflater.inflate(R.layout.row,parent,false);
// inflate custom layout called row 
holder = new ViewHolder();
holder.tv =(TextView) convertView.findViewById(R.id.textView1);  
holder.tv1 =(TextView) convertView.findViewById(R.id.textView2); 
holder.tv2 =(TextView) convertView.findViewById(R.id.textView3); 
// initialize textview
convertView.setTag(holder);
}
else
{
      holder = (ViewHolder)convertView.getTag();
}
      ClientScanResult result = (ClientScanResult)resultList.get(position);
      holder.tv.setText(result.getIpAddr());  
      holder.tv1.setText(result.getDevice()); 
      holder.tv2.setText(result.getHWAddr()); 
      // set the name to the text;

return convertView;

}

static class ViewHolder
{

   TextView tv,tv1,tv2;
} 
}