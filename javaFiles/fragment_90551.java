List<String> upper = new ArrayList<>();
try(BufferedReader in = new BufferedReader(new FileReader("C:\Users\xxx\Desktop\j.txt")))
{
    String line;
    while((line = in.readLine()) != null)
    {
        // upper.add(line.toUpperCase()); // if you need upper case
        upper.add(line.toLowerCase());    // if you need lower case
    }     
}

try(BufferedWriter writer = new BufferedWriter(new FileWriter("C:\Users\xxx\Desktop\j.txt")))
{
    for(String str : upper) 
    {
        writer.write(str);
        writer.newLine(); // remove if not needed.
    }
 }