int x;

boolean cond = true;
if( cond ) {
  x = 5;
}

//The compiler will complain here as well, as it is not guaranteed that "x = 5" will run
System.out.println(x);