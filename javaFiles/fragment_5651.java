if(c.moveToFirst()){

String data = c.getString(c.getColumnIndex("Column's Index"));

yourTextView.setText(data);

}