String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
String word = "Hello!";

boolean notLetterFound;
for (char c : word.toCharArray()){  // loop through string as character array
    if (!set.contains(c)){         // if a character is not found in the set
        notLetterfound = true;    // make notLetterFound true and break the loop
        break;                       
    }
}

if (notLetterFound){    // notLetterFound is true, do something
    // do something
}