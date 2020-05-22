while (n < 10) {
    boolean listis = false;
    number = rand.nextInt(5000);
    for (int k = number - 50; k <= number + 50; k++) {
        if (numbers.contains(k)) {
            listis = true;
            break;
        }
    }
    if (!listis) {
        numbers.add(number);
        n += 1;
    }
}