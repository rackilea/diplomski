public View getView(int position, View convertView, @NonNull ViewGroup parent) 
{   
    View row;
    LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    ChMessage chMessageObj = getItem(position);
    if (chMessageObj.left) {
        row = inflater.inflate(R.layout.leftmessage, parent, false);
    }else{
        row = inflater.inflate(R.layout.rightmessage, parent, false);
    }

        TextView rightMessageView = (TextView) row.findViewById(R.id.rightmsgr);
        TextView leftMessageView = (TextView) row.findViewById(R.id.leftmsgr);
        if (rightMessageView!=null) {
          rightMessageView.setText(chMessageObj.message);
        }
        if (leftMessageView!=null) {
          leftMessageView.setText(Servermessage);
        }

    return row;
}