@Override
public View getView(int position, View convertView, ViewGroup parent) {
   // Get the data item for this position
   Person person = getItem(position);    
   // Check if an existing view is being reused, otherwise inflate the view
   if (person.age == 25) {
      convertView = LayoutInflater.from(getContext()).inflate(R.layout.twice.xml, parent, false);
   }else{
      convertView = LayoutInflater.from(getContext()).inflate(R.layout.once.xml, parent, false);
  }

  //populate views...


}