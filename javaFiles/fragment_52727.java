int sum = 0;
while (kb.hasNextInt()) {
    int score = kb.nextInt();
    if (score == 0) {
        break;
    }
    sum += score;
}
System.out.print(sum);