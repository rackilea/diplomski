// ...

if(kb.hasNextInt()) {                              // <- this will evaluate to false
    monthnumber = kb.nextInt()
    getMonthString(monthnumber);
} else {
    monthNumber = getMonthNumber(kb.nextLine());   // <- this will read "May"
}

//get the day from the userS ;
System.out.print("Enter the day:");  
day = kb.nextInt();                                // <- this will read the "\n" from the Month input. CRASH.

// ...