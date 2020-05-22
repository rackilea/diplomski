// Linear search to match index number  and user input number
for(int i = 0; i < listOfBooks.length - 1; i++) {
    if (listOfBooks.get(i) == number) {
     txtLinearOutput.setText(listOfBooks[i]);
     break; 
}