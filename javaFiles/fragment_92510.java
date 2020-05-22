public String toString(){
    String retuurn = "";
    for (GroceryItem items : item) {
        if(items != null){
            retuurn += item.toString() + "\n"; 
            // Your variable name in your original question is retur, I'm assuming that as typo
        }
    }
    return retuurn;
}