public class AppAdapter extends BaseAdapter {    
    private LayoutInflater layoutInflater;
    private List<AppList> appInList;

    public AppAdapter(Context context, List<AppList> customizedListView) {
        layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        appInList = customizedListView;
    }
    @Override
    public int getCount() {
        return appInList.size();
    }
    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.app_item_layout, parent, false);

            listViewHolder.appNameText = (TextView)convertView.findViewById(R.id.list_app_name);
            listViewHolder.appIcon = (ImageView)convertView.findViewById(R.id.app_icon);
            listViewHolder.appSwitch = (SwitchCompat) convertView.findViewById(R.id.Swtch); //added switchCompat here.
            convertView.setTag(listViewHolder);
        }
        else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }
        listViewHolder.appNameText.setText(appInList.get(position).getName());
        listViewHolder.appIcon.setImageDrawable(appInList.get(position).getIcon());

        /* you can now use your appSwitch here. 
        listViewHolder.appSwitch 
        */

        return convertView;
    }
}
static class ViewHolder {

    TextView appNameText;
    ImageView appIcon;
    SwitchCompat appSwitch; // added switch compat to your viewHolder.
}