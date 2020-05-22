void appendX( StringBuilder sb ) {
  sb.append('x');
}

void foo() {
  StringBuilder builder = ...
  appendX( builder );
  builder.toString(); // will contain 'x' because you worked with the object that 
                      // is the value of the variable `builder`.  When appendX was
                      // was invoked, the value of its variable `sb` was the same 
                      // object that is the value of foo's `builder`.  Without 
                      // changing what value the variable `builder` refers to, we
                      // did "change" the object (i.e., we appended 'x').
}