public String[] numbers(){
    String[] numbers = new String[20];
    for (int i = 0; i<20; i++){
        numbers[i] = Integer.toString(i);  // i is an integer, "transform it into string"
    }
    return numbers;
}