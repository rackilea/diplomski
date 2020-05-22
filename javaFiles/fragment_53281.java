list.setOnItemClickListener(new OnItemClickListener){
    @Override 
    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
           String selected = parent.getAdapter().getItem(position).toString();
           if(selected.equals("htc") {
               //start htc activity
           }
    }
});