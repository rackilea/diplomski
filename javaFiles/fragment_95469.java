@Override
public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder = null;
    NavigationListEntry i = getItem(position);
    if(null == convertView){
        convertView = inflateNewView(i.type);
        holder = (ViewHolder) convertView.getTag();
    } else{
        //getting tag to obtain the already found views
        holder = (ViewHolder) convertView.getTag();
        if(holder.type != i.type){
            convertView = inflateNewView(i.type); 
            holder = (ViewHolder) convertView.getTag();
        }
    }

    //always update the elements 
    holder.title.setText(i.getTitle());
    holder.desc.setText(i.getDesc());
    holder.content.setText(i.getContent());

    return convertView;
}

/**
 * Inflates a new view for the specified type
 * @return the newly inflated view
 */
private View inflateNewView(int type){
        View convertView = null;
        switch(type) {
        case ACTIVE_ENTRY:
            convertView = inflater.inflate(R.layout.list_nav_row_active, null);
            break;
        case HEADER:
            convertView = inflater.inflate(R.layout.list_nav_row_header, null);
            break;
        ...
        default:
            convertView = inflater.inflate(R.layout.list_nav_row_active, null);
            break;
        }
        holder = new ViewHolder();
        convertView = inflater.inflate(LAYOUT_RESOURCE, null);
        holder.title = (TextView) convertView.findViewById(R.id.txtTitle);
        holder.desc = (TextView) convertView.findViewById(R.id.txtDesc);
        holder.content = (TextView) convertView.findViewById(R.id.txtContent);
        holder.type = type;
        //setting tag to reduce hierarchy lookup
        convertView.setTag(holder);

    return convertView;
}
/**
 * Holder class to improve performance. Helps in reducing view hierarchy lookup
 */
private static class ViewHolder {

    TextView title;
    TextView desc;
    TextView content;
    int type;

}