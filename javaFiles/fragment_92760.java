public View getView(int position, View convertView, ViewGroup parent) {

    View rootView = convertView;
    if(rootView == null){


       LayoutInflater inflater = (LayoutInflater)LayoutInflater.from(context);
       rootView = inflater.inflate(R.layout.list_item, parent, false);

       final CustomListItem item = items.get(position);

    }

    if(item != null){
       ImageView imgIcon = (ImageView) rootView.findViewById(R.id.image);
       imgIcon.setImageDrawable(item.getPicture());


       TextView txtLabel = (TextView) rootView.findViewById(R.id.txtLabel);
       txtLabel.setText(item.getLabel());
    }


    return rootView;
}