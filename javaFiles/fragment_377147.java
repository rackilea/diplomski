// I assume here, you've already initialized `tridimensional`
for(i = 0; i < tridimensional.length; i++){
    tridimensional[i] = new int[/*...appropriate size here*/];        // <===
    for(j=0; j < tridimensional[i].length; j++){
        tridimensional[i][j] = new int[/*...appropriate size here*/]; // <===
        for(k=0; k < tridimensional[i][j].length; k++){
             tridimensional[i][j][k] = (int) (Math.random() * 10+1);
        }
    }
}