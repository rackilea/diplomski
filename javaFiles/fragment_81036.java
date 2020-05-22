if (v == null) {
    if(position < 5){//whatever condition you want here    
        v = li.inflate(R.layout.grid_item,null);
    }
    else{
        v = li.inflate(R.layout.grid_item2,null);
    }
}

final TextView tv = (TextView) v.findViewById(R.id.grid_text);
tv.setText(String.valueOf(position+1));