outerLoop: // label the outer for loop
for (int i=0; i<row; i++){
    for (int j=0; j<column; j++) {
        String line = sc.nextLine();
        if ("-1".equals(line)) {
            break outerLoop; // break from the outer for loop
    }
    ...
 }