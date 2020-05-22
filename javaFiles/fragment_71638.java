PrintStream out = ...;
PrintStream err = ...;

System.setOut(out);
System.setErr(err);

ThatOtherProgram foo = new ThatOtherProgram();
foo.main(new String[0]);