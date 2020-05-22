for (int i = 0; i < s.height; i+=10)
    for (int j = 0; j < s.width; j+=10)
        if(yellow)    
            addPixelToListToCheckLater(i, j);

while(pixels still remain to be double checked){
    currenti = nextIInList;
    currentj = nextJInList;

    for (int i = currenti - 10; i < currenti + 10; i++)
        for (int j = currentj - 10; j < currentj + 10; j++)
            if(yellow)    
                count++;

}