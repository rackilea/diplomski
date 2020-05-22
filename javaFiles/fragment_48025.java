void setNull( StringBuilder sb ) {
  sb = null;
}

void foo() {
  StringBuilder builder = ...
  appendX( builder );
  builder == null;  // false, because the value of the variable `builder` is still the 
                    // same object that it was before.  Setting variable `sb` in setNull
                    // to null doesn't affect the variable `builder`. The variables are
                    // just a name so that you can refer to an value.  The only way to
                    // what value a variable refers to is with an assignment.
}