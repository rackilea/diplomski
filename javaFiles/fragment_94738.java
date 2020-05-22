int playerX=0, playerY=0;  //holds player's location
    int exitX = 4, exitY = 4;  //holds exit's location

    //Print map
    for(int x=0; x<5; x++){
        for(int y=0; y<5; y++)
            if(x == playerX && y == playerY)
                System.out.print(" O "); //print player location
            else if(x == exitX && y == exitY)
                System.out.print(" E ");
            else    
                System.out.print(" . ");
        System.out.println("");     
    }
    /*
    //Update player's position on movement
    if (movement == DOWN)
        playerY = Math.min(playerY+1 , 5);
    else if (movement == UP)
        playerY = Math.max(playerY-1 , 0);
    else if (movement == LEFT)
        playerX = Math.max(playerX-1 , 0);
    else else if (movement == RIGHT)
        playerX = Math.max(playerY+1 , 5);  
    */