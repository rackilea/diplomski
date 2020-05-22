static final int NR = 4; //for example

static void main(String[] args) {
    int total = 0;
    for (int i = NR; i > 0; i--)
        total += calculateFactorial(i); //i += j; is the same as i = i + j;
    System.out.println("Answer: " + total);
}