public ArrayList<Integer> numbers() {

    Random randomizer = new Random(); 

    int i = 1;
    int num;

    while (i <= 7) {

        num = randomizer.nextInt(39 + 1);

        if (!numbers.contains(num)); {
            numbers.add(num); 
            i++; 
        }

    }

    return this.numbers;
}