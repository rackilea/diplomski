String string = "Test, I am Adam";
// Anywhere in string
b = string.indexOf("I am") > 0;         // true if contains 

// Anywhere in string
b = string.matches("(?i).*i am.*");     // true if contains but ignore case

// Anywhere in string
b = string.contains("AA")  ;             // true if contains but ignore case