public void drawNumbers()
{
    Random random = new Random();
    int counter = 0;
    int choice;
    while (counter < 7) {
        choice = random.nextInt(39) + 1;
        if (numbers.contains(choice)) {
            continue;
        }
        numbers.add(choice);
        counter++;
    }
}