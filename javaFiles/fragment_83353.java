public View getView(final int position, View convertView, ViewGroup parent) {
    final ViewHolder holder;
    if (convertView == null) {              
        if (position < 10) {
            convertView = mInflater.inflate(R.layout.standard, null);           
        }
        Log.i(TAG, "getView, position = "+position);
        holder = new ViewHolder();
        holder.tv = (TextView) convertView.findViewById(R.id.tv);
        holder.radioButton = (RadioButton) convertView.findViewById(R.id.radioButton1);             
        convertView.setTag(holder);             
    } else {
        holder = (ViewHolder) convertView.getTag();
    }
    ...

    if(position > 10) {
         convertView = mInflater.inflate(R.layout.custom, null);
         Log.i(TAG, "Inflated custom layout");
    }

    Log.i(TAG, "getView() : position = " + position);
}