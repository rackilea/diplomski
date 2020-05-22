StringWriter sr = new StringWriter();
PrintWriter w = new PrintWriter(sr);

// This is where you pass w into your process that does the actual printing of all the lines that you apparently can't control.
w.print("Some stuff");
// Flush writer to ensure that it's not buffering anything
w.flush();

// if you have access to the buffer during writing, you can reset the buffer like this:
sr.getBuffer().setLength(0);

w.print("New stuff");

// write to final output
w.flush();



// If you had access and were clearing the buffer you can just do this.
String result = sr.toString();

// If you didn't have access to the printWriter while writing the content
String[] lines = String.split("[\\r?\\n]+");
String result = lines[lines.length-1];

try
{
    // This part writes only the content you want to the actual output file.
    pw = new PrintWriter(new FileWriter(new File("case2.txt"),false),true);
    pw.Print(result);
}
catch(IOException e)
{
    e.printStackTrace();
}