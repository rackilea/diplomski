String space;
for (int i = 1; i < 10; i ++) {
    space = ""; // declare a variable here
    for (int j = 1; j < 10; j++) {
        System.out.print(space + i * j); // and note here to change the order
        space = " "; // after the first iteration set a space to the variable
    }
    System.out.println();
}