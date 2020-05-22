ArrayList<int> odds = new ArrayList<int>();

for (int number = -6; number <= 38; number++) {
    if(number % 2 == 1)
        odds.add(number);
}