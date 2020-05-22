String str = "12/16/2011 12:00:00 AM";

// method 1: String.substring with String.indexOf
str.substring(0, str.indexOf(' '));

// method 2: String.split, with limit 1 to ignore everything else
str.split(" ", 1)[0];