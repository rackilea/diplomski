// ... rest of your code
int store = m - n;
if(store > 0){
    countToBy(store, m );     // use store instead of n-m because you already calculated that
    System.out.print(", ");   // print the comma inside the statement, because (store > 0) means we have more elements to come
} 
System.out.print(n);          // print the current element
// ...