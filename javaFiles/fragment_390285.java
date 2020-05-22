int myInt = 7;

// Wrap the primitive value
Integer myWrappedInt = Integer.valueOf(myInt);

// Unwrap the value
int myOtherInt = myWrappedInt.intValue();