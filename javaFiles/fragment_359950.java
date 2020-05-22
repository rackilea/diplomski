public int getIndex(EN){
    int myIndex = -1;
    for(int i=0;i<empArray.length;i++){
        if(empArray[i].getEN()==EN){// Assuming EN is a number, else if its a String, use the equals() method.
            myIndex = i;
            break;
        }
    }
    return myIndex;
}