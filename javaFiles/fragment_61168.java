System.out.printf("%2d", i + 1);
System.out.print(month[i] != null ? '*' : ' ');
if (++currentDay < 7) {
    System.out.print(' ');
} else {
    System.out.println();
    currentDay = 0;
}