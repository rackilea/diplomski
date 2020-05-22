// init the array
for (int i = 0; i < table.length; i++) {
    for (int j = 0; j < table[i].length; j++) {
        table[i][j] = "—";
    } 
}
while(true){
    // print the array
    for (int i = 0; i < table.length; i++) {
        for (int j = 0; j < table[i].length; j++) {
            System.out.print(table[i][j] + " ");
        } 
        System.out.println();
    }
    for (int i = 0; i < options.length; i++) {
        for (int j = 0; j < options[i].length; j++) {
            System.out.print(options[i][j]+ " ");
        }// FOR LOOP 2(2)
        System.out.println();
    }// FOR LOOP 1(1)
    // ASK FOR MOVE ONE
    System.out.println("Player One (x) : Enter a move from 1-9 >>> ");
    int x = in.nextInt();
    if (x==1){
        table[0][0]="x";
    }
}