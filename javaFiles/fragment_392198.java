PrintStream oldErr = System.err;
PrintStream newErr = new PrintStream(new ByteArrayOutputStream());
System.setErr(newErr);

// do your work

System.setErr(oldErr);