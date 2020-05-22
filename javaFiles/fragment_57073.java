public class SettingsAdapter extends ArrayAdapter<SettingsList> {


    public SettingsAdapter(Context context, int resource, List<SettingsList> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderItems holder;
        if(convertView == null){
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.list_row_item, parent, false);
            holder = new ViewHolderItems();
            holder.holderImage = (ImageView)convertView.findViewById(R.id.imageForList);
            holder.holderText = (TextView)convertView.findViewById(R.id.textForList);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolderItems)convertView.getTag();
        }
            SettingsList current = getItem(position);
            holder.holderImage.setImageResource(current.getImage());
            holder.holderText.setText(current.getItem());

        return convertView;
    }

    static class ViewHolderItems{
        ImageView holderImage;
        TextView holderText;
    }
}