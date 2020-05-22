RememberAllWrittenTextPrintStream ps
        = new RememberAllWrittenTextPrintStream(System.out);
System.setOut(ps);
System.out.print("bla");
System.out.print("bla");
ps.getAllWrittenText(); // should now return "blabla"