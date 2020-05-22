class MyAdapter extends ArrayAdapter<String>{
                             final int which;
ArrayList<Boolean> mListImageStates = new ArrayList<Boolean>();
 public MyAdapter(Context context, int resource,
   int textViewResourceId, String[] string) {
   super(context, resource, textViewResourceId, string);
    for(int i = 0; i<string.length;i++)
    {
        mListImageStates.add(new Boolean(false));
    }
 }
@Override
public View getView(int position, View convertView, ViewGroup parent) {
int which=position;
LayoutInflater inflater =  (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

 ChildViewHolder holder = new ChildViewHolder();
 if(convertView == null){
      convertView = inflater.inflate(R.layout.custom_view, parent,false);
      holder.mTv = (TextView) row.findViewById(R.id.textView1);
      holder.mIv = (ImageView) row.findViewById(R.id.imageView1);
      holder.mTb = (ToggleButton) row.findViewById(R.id.toggleButton1);
      convertView.setTag(holder)}
 else
 {
      holder = (ChildViewHolder) convertView.getTag();
 }
 holder.mTv.setText(myArr.get(position).toString());

  holder.mTb.setOnClickListener(new OnClickListener() {
  @Override
  public void onClick(View v) {        
         boolean listState = mListImageStates.get(position);
         mListImageStates.set(position,new Boolean(!listState));
         notifyDataSetChanged();

}});

if(mListImageStates.get(position) == false)
{
//TODO
}else
{
//TODO
}

   return convertView;
}
class ChildViewHolder
{
    public TextView mTv;
    public ImageView mIv;
    public ToggleButton mTb;
}