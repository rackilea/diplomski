// ...

if(kb.hasNextInt()) {                              // <- this will evaluate to false
    monthnumber = kb.nextInt()
    getMonthString(monthnumber);
} else {
    monthNumber = getMonthNumber(kb.nextLine());   // <- this will read "May"
    in.nextLine();                                 // consume the "\n"
} 

// ...