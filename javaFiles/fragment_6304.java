public class TerbaruAdapter extends BaseExpandableListAdapter{
    Context context;
    ArrayList<TerbaruModel>ListTerbaru;
    ArrayList<ArrayList<ChildTerbaru>> ListChildTerbaru;
    int count;

    public TerbaruAdapter (Context context, ArrayList<TerbaruModel>ListTerbaru,ArrayList<ArrayList<ChildTerbaru>> ListChildTerbaru){
        this.context=context;
        this.ListTerbaru=ListTerbaru;
        this.ListChildTerbaru=ListChildTerbaru;
//      this.count=ListTerbaru.size();
//      this.count=ListChildTerbaru.size();
    }
    @Override
    public boolean areAllItemsEnabled()
    {
        return true;
    }


    @Override
    public ChildTerbaru getChild(int groupPosition, int childPosition) {
        return ListChildTerbaru.get(groupPosition).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,View convertView, ViewGroup parent) {

        ChildTerbaru childTerbaru = getChild(groupPosition, childPosition);
        ViewHolder holder= null;

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.expandablelistview_child, null);

            holder=new ViewHolder();
            holder.begdate1=(TextView)convertView.findViewById(R.id.beg_date);
            holder.enddate1=(TextView)convertView.findViewById(R.id.end_date);
            convertView.setTag(holder);

        }
        else{
            holder=(ViewHolder)convertView.getTag();
        }

        holder.begdate1.setText(childTerbaru.getBegDate());
        holder.enddate1.setText(childTerbaru.getEndDate());

        return convertView;
    }
    @Override
    public int getChildrenCount(int groupPosition) {
        return ListChildTerbaru.get(groupPosition).size();
    }

    @Override
    public TerbaruModel getGroup(int groupPosition) {
        return ListTerbaru.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return ListTerbaru.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        TerbaruModel terbaruModel = (TerbaruModel) getGroup(groupPosition);
        ViewHolder holder= null;
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.expandablelistview_group, null);

            holder=new ViewHolder();
            holder.nama=(TextView)convertView.findViewById(R.id.name);
            holder.alamat=(TextView)convertView.findViewById(R.id.address);
            convertView.setTag(holder);

        }

         else{
            holder=(ViewHolder)convertView.getTag();
         }

        holder.nama.setText(terbaruModel.getNama());
        holder.alamat.setText(terbaruModel.getAlamat());

         return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int arg0, int arg1) {
        return true;
    }


    static class ViewHolder{
        TextView begdate1, enddate1,nama, alamat, imageid;
    }

}