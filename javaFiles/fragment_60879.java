if ( y == 1 ) goto case_1;
if ( y == 2 ) goto case_2;

// here comes the default:
default:
System.out.println("Unexpected number of eyes: " + y);
goto switch_done;

case_1:
  ones++;
  goto switch_done; // this is the 'break' statement.

case_2:
  twos++;
  goto switch_done; 

switch_done:  // end of the switch.