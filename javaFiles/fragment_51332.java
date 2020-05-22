private String divisor(int num) {

    StringJoiner sj = new StringJoiner(", ");
    for (int i = 1; i <= num; i++) {
        if (num % i == 0) {
            sj.add(Integer.toString(i));
        }
    }
    return sj.toString();
}