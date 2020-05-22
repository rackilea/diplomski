//for loop here to copy items over into the new resized array.
//We use two counters here, ii for the old list and i for the new
int ii = 0, nn = strings.length;
for(int i = 0, n = newSizedList.length; i < n; i++) {

    if(ii != nn && (ii != i || strings[ii].compareTo(a) < 0)){
        //The item in newSizedList[i] will be taken from the original list if
        //we have not already taken all the items from there (ii != nn) and
        //a) we have already inserted the new item (ii != i)
        //or b) a is alphabetically "greater" than the corresponding item in original array
        newSizedList[i] = strings[ii];
        ii++;//Keep the other counter in sync
    } else  {
        //Otherwise, this is the place for the new item
        newSizedList[i] = a;
    }

}