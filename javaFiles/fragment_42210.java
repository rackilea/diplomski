float total = 0;
for(int i = 0; i < myList.size(); i++){
    MyObject myObject = myList.get(i);
    total += myObject.getPrice(); // create getter in your MyObject class
}

Log.d("TAG", "Total price is: " + total);