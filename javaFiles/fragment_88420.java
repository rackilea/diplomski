float smallest = Integer.MAX_VALUE; 
for(int x=0; x<priceArr.length; x++) {
    if(smallest < priceArr[x] && priceArr[x] != 0) {    //additional condition here
        smallest = priceArr[x];
    }
}