String s;
synchronized(list) {
    s = list.peek();
}
// <<== Problem ==>>
if (s != null) {
    synchronized(list) {
        s = list.pop();
    }
}