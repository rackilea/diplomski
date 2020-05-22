for (int x = 0 ; x < field.length ; x++) {
    for (int y = 0 ; y < field[x].length ; y++) {
        /*
        The '1' area can be represented by these inequalities:
        x - y < 0
        x + y < array.length - 1
        The '2' area can be represented by these inequalities:
        x - y < 0
        x + y > array.length - 1
        The '3' area can be represented by these inequalities:
        x - y > 0
        x + y > array.length - 1
        The '4' area can be represented by these inequalities:
        x - y > 0
        x + y < array.length - 1
        Everywhere that does not satisfy any of the inequalities are *s
         */
        int xMinusY = x - y;
        int xPlusY = x + y;
        if (xMinusY < 0 && xPlusY < field.length - 1) {
            field[x][y] = '1';
        } else if (xMinusY < 0 && xPlusY > field.length - 1) {
            field[x][y] = '2';
        } else if (xMinusY > 0 && xPlusY > field.length - 1) {
            field[x][y] = '3';
        } else if (xMinusY > 0 && xPlusY < field.length - 1) {
            field[x][y] = '4';
        } else {
            field[x][y] = '*';
        }
    }
}

// ...

// printing the array out:

for (int x = 0 ; x < field.length ; x++) {
    for (int y = 0 ; y < field.length ; y++) {
        System.out.print(field[x][y]);
    }
    System.out.println();
}