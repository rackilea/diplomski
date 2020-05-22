public void addUniqueRandom(List<Integer> list) {
    int nextInt;
    do {
        nextInt = rand.nextInt(1001);
    } while(list.contains(nextInt));

    list.add(nextInt);
}

ArrayList<Integer> a =  new ArrayList<Integer>();

ArrayList<Integer> c = new ArrayList<Integer>();

for(int i = 0; i < 10; i++) {
    addUniqueRandom(a);
    addUniqueRandom(c);
}