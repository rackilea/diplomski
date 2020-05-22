// Take this example (and also try it)
for (int i = 0; i < 10; i++) 
{
   System.out.println(i);
}


// Explanation
for(int i = 0; // the value to start at  - in this example 0
    i < 10;    // the looping conditions - in this example if i is less than 10 continue 
               //         looping executing the code inclosed in the { }
               //         Once this condition is false, the loop will exit
    i++)       // the increment of each loop - in this exampleafter each execution of the
               //         code in the { } i is increments by one
{
   System.out.println(i);  // The code to execute
}