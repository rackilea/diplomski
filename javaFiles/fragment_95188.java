String s=what you already have;

//split the string into lines
String[] lines=s.split("\n");

//cut off the beginning of each one
for(int i=0;i<lines.length;i++)
    lines[i]=lines[i].substring(/*1, 2, 4, or 8 depending on tab formatting*/);
return s;