// Create two Strings. [string1]="abc", [string2]="def"
// Assign [string1] to arr[0]. 
// Assign [string2] to arr[1].
String[] arr={"abc","def"};

// Get value from arr[1] = [string2]
// Assign [string2] to s
String s=arr[1];

// Get value from arr[1] = [string2]
// create [string3] = "123r"
// create [string4] = [string2] + [string3]
// assign [string4] to arr[1]
arr[1]+="123r";

// get value from arr[0] = [string1]
// print [string1] = "abc"
// get value from arr[1] = [string4]
// print [string4] = "def123r"

for (String i:arr) {System.out.print(i);}

System.out.println(); // prints "abcdef123r"

// get value from s = [string2]
// print value "def"
System.out.println(s); //prints "def"