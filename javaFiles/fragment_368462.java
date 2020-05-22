// Create a stream to hold the output
ByteArrayOutputStream baos = new ByteArrayOutputStream();
PrintStream ps = new PrintStream(baos);
// IMPORTANT: Save the old System.out!
PrintStream old = System.out;
// Tell Java to use your special stream
System.setOut(ps);
// Print some output: goes to your special stream
System.out.println("Foofoofoo!");
// Put things back
System.out.flush();
System.setOut(old);
// Show what happened
System.out.println("Here: " + baos.toString());