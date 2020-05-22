public ArrayList<String> getItems(){
    return this.items;
}

public void setItems(ArrayList<String> items){
    this.items = items;
    notifyDataSetChanged();
}