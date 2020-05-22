x = 10;
if(x ==10) { // start new scope
int y = 20; // known only to this block
x = y * 2;
}

y = 5; // error y is out of scope, not it is not defined