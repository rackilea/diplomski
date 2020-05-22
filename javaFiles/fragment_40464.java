String s = "...";

int start = s.indexOf("_") + 1;
int end = s.indexOf("_", start);

// name will hold the content of s between the first two `_`s, assuming they exist.
String name = s.substring(start, end);