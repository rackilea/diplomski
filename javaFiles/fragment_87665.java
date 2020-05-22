list.setOnItemClickedListener(new OnItemClickedListener() {
AdapterView<?> parent, View view, int position, long id){
    Textview i1 = view.findViewById(R.id.t1);
    Textview i2 = view.findViewById(R.id.t2);
    String text = i1.getText()+i2.getText();
    }
} ;