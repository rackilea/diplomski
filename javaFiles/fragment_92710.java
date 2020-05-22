int rows = 5;
int columns = 3;
String symbol = "@";

System.out.println("Here comes the magic...\nHere's your very own magic box!");

for (int count1 = 1; count1 <= rows; count1++) {
    for (int count2 = 1; count2 <= columns; count2++) {
        System.out.print(symbol);
    }
    System.out.println();
}

System.out.println("This magic box brought to you by Beth Tanner.");