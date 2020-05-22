// borrowed reader from example 1
BufferedReader br = new BufferedReader (new FileReader("b.txt")); 
BufferedWriter bw = new BufferedWriter (new FileWriter("a.txt", true)); 
String x;

// this part didn't work.  You were trying to read from a writer, as you write to it.
// if this were an object capable of reading and writing at the same time, you would
// run into issues because they wouldn't be rewinding after each operation and you'd
// end up with a combination of unexpected mirrored lines and garbled crap.

// changed loop to read from reader.  reads data from one file, line by line, and
// writes to another.
while ((x = br.readLine()) != null) 
{
    bw.write(x);  // in the other order, file will start with a blank line
    bw.newLine(); // in this order, file will end with one instead
}
bw.flush(); // its better if this is not in the loop