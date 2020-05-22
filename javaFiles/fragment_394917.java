public static void printChars(char ch1, char ch2, int charsPerLine)
{
    int difference = (int) (ch2 - ch1);

    for (int i = 1; i < difference; i++) { // Adjust the range, start in 1 so it doesn't print another line when i == 0
        System.out.print(++ch1 + " ");
        if (i % charsPerLine == 0) { // Just check if (i % 4 == 0)
            System.out.print("\n");
        }
    }
}