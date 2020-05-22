int i, j;
Point_1:
for (i = 1; i <= 10; i++) {
    for (j = 1; j <= 10; j++) {
        System.out.print(j);
        if (j == 5) {
            // break Point_1; --> goto Break_Label;
            // continue Point_1; --> goto Continue_Label;
        }
    }
    System.out.println();
    Continue_Label:
}
Break_Label: