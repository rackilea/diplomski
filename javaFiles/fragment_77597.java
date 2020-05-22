// Our 2D replacement array. In the first column we place 
// the substrings we would like to find within our input 
// string and in the second column we place what we want 
// to replace the item in the first column with if it's 
// found.
String[][] replacements = {{"SomeProductSet1", "[abc]"}, 
                           {"SomeOtherProductSet2", "[xyz]"},
                           {"SomeProductSet3", "[xom]"},
                           {"SomeUSOC4", "[ytkd]"}};

// The string we want to modify (the input string):
String example = "something + {SomeProductSet1}.count + {SomeOtherProductSet2}.amount > \n" +
                 "    {SomeProductSet3}.count + {SomeUSOC4}.amount";

// Lets make the call and place the returned result
// into a new variable...
String newString = replaceBetween(example, "{", "}", replacements);

// Display the new string variable contents
// in Console.
System.out.println(newString);