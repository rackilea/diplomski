String s1 = "spring ";             // "spring" created, reference s1 changed
String s2 = s1 + "summer ";        // "summer", "spring summer" created, "summer" not saved, reference s2 changed
s1.concat("fall ");                // "fall", "spring fall" created but not saved
s2.concat(s1);                     // "spring summer spring" created but not saved
s1 += "winter ";                   // "winter", "spring winter" created, reference s1 changed
System.out.println(s1 + " " + s2); //" ", "spring winter spring summer" created, " "  not saved