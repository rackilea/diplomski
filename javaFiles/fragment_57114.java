while((line=br.readLine())){

//Make sure the line is not null, not empty, and contains 3 comma char
if (line != null && !line.equals("") && line.matches('.*[,].*[,].*[,].*')) {
    String tmp[]=line.split(",");
    date=tmp[0];
    heure=tmp[1];
    parametre=tmp[2];
    valeur=tmp[3];

// do the sql query

} else {
    // manage where the line doesn't fit the pattern
}