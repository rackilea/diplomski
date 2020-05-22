public View getView(int position, View convertView, ViewGroup parent) { 
    ViewHolder holder;
    if (convertView == null) { 
   // if convertView is null 
       convertView = mInflater.inflate(R.layout.mylayout, parent, false); 
       holder = new ViewHolder(); 
       // initialize views
       convertView.setTag(holder); 
      // set tag on view
     }
    else { 
       holder = (ViewHolder) convertView.getTag(); 
       // if not null get tag // no need to initialize 
    } //update views here return convertView; 
}