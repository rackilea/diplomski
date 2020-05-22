public void displayItems(){
  for(int i=0;i<items.length;i++){
     SalesItem temp = items[i];
     System.out.prinlnt(temp.toString());//or this may be temp.getName() or whatever returns a string from this SalesItem object - I dont know what it looks like - you never said!

  }
}