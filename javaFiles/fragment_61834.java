double r;
// code goes INSIDE the `do ... while` loop
// each iteration is a new throw of the dice
do {
    // assign random value to int
    r = (int) (6 * Math.random()) +1;        
    // Printing the result
    switch(r) {
        case 1:
            System.out.print(set1);
            break;
        case 2:
            System.out.print(set2);
            break;
        case 3:
            System.out.print(set3);
            break;
        case 4:
            System.out.print(set4);
            break;
        case 5:
            System.out.print(set5);
            break;
        case 6:
            System.out.print(set6);
            break;
    } 
} while(r != 6);