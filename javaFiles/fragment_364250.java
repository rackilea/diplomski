final Object o = "Hello!"; // in fact this calls new String("Hello!")

o.toString(); // <-- uses String's .toString(), not Object's

// Can't do that: String defines .subString() but Object does not
o.subString(1);