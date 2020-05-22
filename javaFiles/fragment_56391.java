for (  c = 0 ; c < m ; c++ ) {
    for(d = 0; d < n; d++) {
        if(x == matrice[c][d]) {
            nr++;
        }
    }
}
System.out.println("Number x appears " + nr + " times.");`