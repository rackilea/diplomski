@Override
public View getView (int position, View convertView, ViewGroup parent) {
  if (convertView == null) {
    convertView = inflater.inflate(resource, parent, false);
  }
  // continue the rest of the cell data filling
}