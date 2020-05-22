// Your counter
int counter = 0; 

// The contents of this will execute 100 times
for(gallons = 1; gallons <= 100; gallons++) { 

    // Omitted for brevity

    // This increases your counter by 1
    counter++; 

    // Since your counter is declared outside of the loop, it is accessible here
    // so check its value
    if(counter == 10) { 

         // If it is 10, then reset it
         System.out.println(); 
         counter = 0; 
    } 

    // At this point, the loop is over, so go to the next iteration
}