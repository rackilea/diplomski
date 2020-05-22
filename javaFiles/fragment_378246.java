public static void fun() {
    table = new char[][] {
            {'A','B','C',   'D','E','F',   'G','H','I'},
            {'G','H','I',   'A','B','C',   'D','E','F'},
            {'D','E','F',   'G','H','I',   'A','B','C'},  

            {'I','A','B',   'C','D','E',   'F','G','H'},
            {'F','G','H',   'I','A','B',   'C','D','E'},
            {'C','D','E',   'F','G','H',   'I','A','B'},

            {'H','I','A',   'B','C','D',   'E','F','G'},
            {'E','F','G',   'H','I','A',   'B','C','D'},
            {'B','C','D',   'E','F','G',   'H','I','A'} };
}

public static void printTable() {
    for(int x=0; x<9; x++) {
        for(int y=0; y<9; y++) { 
            System.out.print(table[x][y]+ " ");
        }
    }
}