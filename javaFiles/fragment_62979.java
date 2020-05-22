public void mutate() {
    Random rand = new Random();
    int mutPos = rand.nextInt(valueString.length());
    valueString = valueString.substring(0, mutPos) 
        + rand.nextInt(10) + valueString.substring(mutPos+1);
}