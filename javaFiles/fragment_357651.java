List<Item> myList = new ArrayList<Item>();
String userInputValue;

// * Add some items to myList
// ...

// * Get user input value
// ...

// * Access the array list
int len=myList.size();
for(int i=0; i<len; i++) {
    if (myList.get(i).getItemName().equals(userInputValue)) {
        // Do something ...
    }
}