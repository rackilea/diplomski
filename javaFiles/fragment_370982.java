if( x < 5) { // any input less than 5 will execute this if statement and will NOT proceed to the next blocks
     System.out.print("This is if statement");
}else if(x<3){ // this is not reachable because the first if statement will catch all inputs less than 5 INCLUDING those less than 3
     System.out.print("This is else if statement");
}else{
     System.out.print("This is else statement");
}