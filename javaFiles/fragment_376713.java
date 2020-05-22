public void getAllItems(ArrayList<ModelItem> items, String searchItem) {
for(ModelItem item : items) {
 if(item.getItemName().contains(searchItem)) {
    // here you are getting item which matches inside your list
}
}