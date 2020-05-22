while(counter < 1000) {
    int val;
    do{
        val = rnd.nextInt(Integer.MAX_VALUE);
    }while(ar.contains(val));
    ar.add(val);
}