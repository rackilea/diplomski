/** Read count integers using Scanner */
static int scanInteger(int count) {
    Scanner scanner = new Scanner(input);
    int last = 0;
    while (count-- > 0) {
        last = scanner.nextInt();
    }
    return last;
 }