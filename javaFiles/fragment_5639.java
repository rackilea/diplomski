PrintStream oldErr = System.err();
ByteArrayOutputStream baos = new ByteArrayOutputStream();
PrintStream newErr = new PrintStream(boas);
System.setErr(newErr);
tidy.parse(...);
System.setErr(oldErr);