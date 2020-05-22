// get first char in the input string
char value = et.getText().toString().charAt(0);

int nextValue = (int)value + 1; // find the int value plus 1

char c = (char)nextValue; // convert that to back to a char

et.setText( String.valueOf(c) ); // print the char as a string