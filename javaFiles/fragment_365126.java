BufferedReader in = null;
String input = "";
in = new BufferedReader(fin);
while ((input = in.readLine()) != null)
{
    System.out.println(input); // for me to see the output
    out.println(input); // thats for my server
    out.flush(); // for the server
}