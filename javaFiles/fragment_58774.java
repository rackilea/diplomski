while (integer>0) {
    while (x < integer)
    {   
        g.drawString("hi", 200, y); 
        x+=1;
        y = y+40; //test
    }//end while
    integer --; // <-- This is missing
}
break; // <-- Also missing