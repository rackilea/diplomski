Object[] filesThenStrings = new Object[n];

//Populate filesThenStrings with File objects here, 
//this is legal since all classes are a subclass of Object 
//and java does upcasting for you

for(int i = 0; i < n; i++) {
  filesThenStrings[i] = someString; //where this is the string you
                                    //want to replace the i-th file with
}