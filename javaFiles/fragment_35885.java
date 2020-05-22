public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) getContext()
         .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    convertView = inflater.inflate(R.layout.rowcustom, null);
    Message msg = getItem(position)

    if (msg.isSent()) {
    // Message is sent
    }
    else {
    // Message is received

    }

    return convertView;
}