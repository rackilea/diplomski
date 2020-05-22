private View getViewForPageOne(){
    View v = getLayoutInflater().inflate(R.layout.layout_page_one, null);
     TextView whatText =(TextView) v.findViewById(R.id.idOfTextView);
     whatText.setText("Page One");
     ....
     ....

     return v;
}