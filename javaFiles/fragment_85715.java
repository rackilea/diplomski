int searchKey = 33; // search for item
int indexToDisplay = arr.find(searchKey);
if(indexToDisplay != -1)
    System.out.println("Found " + searchKey + " at index: " + indexToDisplay );
else
    System.out.println("-1");