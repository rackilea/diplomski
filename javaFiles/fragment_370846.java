// Your link string
String link  = "/aaa/bbbb/cake/123_asd&%?/reg ex+";

// Your delimiter 
String variable = "cake"; 

// Variable to hold the string contents located
// after the delimiter
String textAfterVar = "";    

/*
To fill the textAfterVar string variable we're 
going to use the Pattern Matcher method and a small 
regex expression for obtaining the string portion  
found after our delimiter.
Here we establish our pattern to use and place it into
a variable conveniently named pattern....  */
Pattern pattern = Pattern.compile("(?i).*(" + variable + ")+(.*)");
/*
Breakdown of the expression string: ".*(" + variable + ")+(.*)"
(?i)        Ignore letter case. Remove if you want to be case sensitive.
.*          Match any character 0 or more times (except newline).
(           Group 1 Start...
+variable+  The string variable which holds our delimiter string. 
            Will be held as Group 1.
)           Group 1 End.
+           Match one or more of the previous item which in this case is 
            the contents of our variable.
(           Group 2 Start... This group will be any text after the delimiter.
.*          Match any character 0 or more times (except newline).
)           Group 2 End.  */

/*
We now run the pattern through the matcher method to
see if there is a match to our regex expression.  */
Matcher matcher = pattern.matcher(link);

// See if the matcher method finds a match to our expression.
// If so place the contents into the textAfterVar string variable.
if (matcher.find()) { textAfterVar = matcher.group(2); }

// Display the contents of the textAfterVar string 
// variable in output console (pane).
System.out.println(textAfterVar);