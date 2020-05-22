int n = myList.size();
for (int i=n/2; i-->0;) {
    Object o = myList.get(i);
    myList.set(i, myList.get(n-i-1));
    myList.set(n-i-1, o);
}