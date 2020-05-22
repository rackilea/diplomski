int placehodler = numbers[0] + 1; 
for (int i = 1; i < numbers.length(); i++){
     if (placeholder !=  numbers[i]) // checks if the next number is equal to the previous  + 1
           break; // breaks out of the loop if it isn't
     placeholder++; // increment placeholder by 1
}

System.out.println(placeholder); // prints placeholder