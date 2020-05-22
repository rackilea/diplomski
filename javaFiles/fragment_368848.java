int read = 0, write = 0;
while (read < myList.size()) {
    String s = myList.get(read);
    if (s.equals("NEW ROW")) {
        read += x;
    } else {
        myList.set(write++, s);
        read++;
    }
}
// Trim the end of the list
for (int last = myList.size()-1 ; last >= write ; last--) {
    myList.remove(last);
}