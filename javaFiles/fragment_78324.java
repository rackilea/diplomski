synchronized(list) {
    String s = list.peek();
    if (s != null) {
        s = list.pop();
    }
}