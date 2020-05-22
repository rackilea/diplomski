public MyAdapter(List<ListItem> listItems, Context context) {
    for(int i=0;i<listItems.size(); i++){
        if (listItems.get(position).getHead().equals("Time")){
            listItems.remove(listItems.get(position));
        }
     }
     this.listItems = listItems;
     this.context = context;
}