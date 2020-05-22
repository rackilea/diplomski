String sentence = "this is my sentence \"course of math\" of this year"; 
String[] MyStrings = sentence.split(" "); // Split with a space
String res = "";
for(int i=0; i < MyStrings.length; i++)  // Iterate over the split parts
{
    if(MyStrings[i].startsWith("\""))    // Check if the split chunk starts with "
    {
        res = MyStrings[i].substring(1); // Get a substring from Index 1
        break;                           // Stop the iteration, yield the value found first
    }
}
System.out.println(res);