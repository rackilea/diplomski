public static void organiseFile() throws FileNotFoundException {
ArrayList<String> lines = new ArrayList<>();
ArrayList<String> order = new ArrayList<>();
String directory = "C:\\Users\\xxx\\Desktop\\Files\\ex1";
Scanner fileIn = new Scanner(new File(directory + "_ordered.txt"));
PrintWriter out = new PrintWriter(directory + "_orderesqsd.txt");

String otherStates = "";
ArrayList<String> otherStates_duplicate = new ArrayList<>();
String ordered_new_string.;

while (fileIn.hasNextLine() == true) {
    lines.add(fileIn.nextLine());
    System.out.println("Organising...");
}
Collections.sort(lines);
for (String output : lines) {
    if (output.contains("[EVENT=agentStateEvent]")) {
        out.println(output + "\n");
        out.println(otherStates + "\n");
        otherStates = "";
    }
    else {
    otherStates += output+ "\n"; 
    otherStates_duplicate.add(output);

}
Collections.sort(otherStates_duplicate); // Now this should have a sorted list

//if you need a string instead of an arraylist use code below in addition
for(String s:otherStates_duplicate){ 

ordered_new_string += s + "\n";

}

/*
I have not printed or stored the string ordered_new_string as it is not
 clear to me what you want. print/write to a file and check 
if ordered_new_string is what your required

*/

out.close();
}