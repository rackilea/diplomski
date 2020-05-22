public class SpinnerCustomAdapter extends BaseAdapter {
    private Context mContext;
    private List<JobSearchModel> mList=new ArrayList<JobSearchModel>();
    private LayoutInflater mLayoutInflater;
    private String mType=null;


    public SpinnerCustomAdapter(Context mContext, List<JobSearchModel> list) {
        this.mContext=mContext;
        this.mList=list;

    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        LayoutInflater layoutInflater=(LayoutInflater)mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView==null){
            convertView = layoutInflater.inflate(R.layout.layout_spinner, null);
            holder = new ViewHolder();
            holder.textView2=(TextView)convertView.findViewById(R.id.txt_text2);
            convertView.setTag(holder);

        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        JobSearchModel classModel=mList.get(position);
        String id = mList.get(position).getId();
        if(id.equals("select")){
            holder.textView2.setTextColor(mContext.getResources().getColor(R.color.lightblack));
        }else{
            holder.textView2.setTextColor(mContext.getResources().getColor(R.color.black));
        }
        holder.textView2.setText(classModel.getDescription());
        return convertView;
    }
    static class ViewHolder{

        TextView textView2;
    }
}