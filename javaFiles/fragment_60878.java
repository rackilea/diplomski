if ( y != 1 )
   goto not_1;

// this is the 'then' part:
System.out.println("It is 1");
goto done;   // we don't want to run the 'else' part!

not_1:
// this is the 'else' part
System.out.println("It is not 1");

done: