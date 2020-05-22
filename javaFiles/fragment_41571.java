//Since each index will only be holding one character, 
//it makes sense to use char array instead of a string array.
//This next line creates a char array with 40 empty indexes.
char[] timestamp = new char[40];

//The variable name to store user input as a string. 
String name;

//message to user to input name  
System.out.println("Pls enter a name and surname");

//Create a scanner to get input from keyboard, and store user input in the name variable  
Scanner sc = new Scanner(System.in);  
name = sc.nextLine();

//if you wanted the length of the char array to be the same
//as the characters in name, it would make more sense to declare it here like this
//instead of declaring it above.
char[] timestamp = new char[name.length()];


//For loop, loops through each character in the string and stores in
//indexes of timestamp char array. 
for(int i=0; i<name.length;i++)
{
    timestamp[i] = name.charAt(i);
}