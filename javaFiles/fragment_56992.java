j = i - 1;  //initialize j!!!
String key = a[i];   //take value
while((j >= 0) && (a[j].compareTo(key) > 0)){//Compare with key!!!
     a[j+1] = a[j];
     j--;
}
a[j + 1] = key; //index is j here!!!!