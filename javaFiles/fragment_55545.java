public void printStandard(int hrs, int mins, int secs) {
if (hrs < 12) {
    System.out.printf("%02d:%02d:%02d AM%n", hrs, mins, secs);
} else {
    System.out.printf("%02d:%02d:%02d PM%n", hrs - 12, mins, secs);
}