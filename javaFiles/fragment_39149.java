MWComponentOptions options = new MWComponentOptions();
PrintStream o = new PrintStream(new File("MATLAB log.log"));

options.setPrintStream(o); // send all standard dips() output to a log file
// the following ignores all error output (this will be caught by Java exception handling anyway)
options.setErrorStream((java.io.PrintStream)null);

// instantiate and use the exported class
myClass obj = new myClass(options);
obj.myMatlabFunction();
// etc...