@Override
public View getView(int position, View convertView, ViewGroup parent) {  
View view = super.getView(position, convertView, parent);  
if (position == 2) {
    view.setBackgroundColor(Color.BLUE);  
} else {
    view.setBackgroundColor(Color.CYAN);  
}

return view;  
}