for (int i=0;  i<orig.size(); ) {
    if (orig.get(i) >= mid) {
        orig.remove(i);
    }
    else {
        i++;
    }
}