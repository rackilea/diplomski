int index = 0; 
int elementLength = array[0].length();
for(int i=1; i< array.length(); i++) {
    if(array[i].length() > elementLength) {
        index = i; elementLength = array[i].length();
    }
}
return array[index];