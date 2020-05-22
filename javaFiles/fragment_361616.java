int current = array.get(0);
//do something with that number
for (int i=1; i<array.size(); i++) {
    if (array.get(i) >= current + 30) {
        //do something with that number
        current = array.get(i);
    }
}