try {
    for(row=row-1;row>=0;row--) {
       if(tablero[col1][row]==".") {
           tablero[col1][row]="X";
           break;
       }
    }
} catch (ArrayIndexOutOfBoundsException ex) {
    // do something
}