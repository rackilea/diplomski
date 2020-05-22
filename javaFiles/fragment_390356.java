//if option is not v or V, execute code and only display total moves
//else, user typed v or V and moves are displayed
if (c == lstep || c == lsteps){
    hanoi(iHeight, source, destination, auxiliary); 
    System.out.println(" Move disc from needle "+source+" to "+destination);
    System.out.println(" Total Moves : "+moves);
} else {
    hanoi(iHeight, source, destination, auxiliary);
    System.out.println(" Total Moves : "+moves);
}