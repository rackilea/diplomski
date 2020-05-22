String foo = "This is a String";
for (int i = 0; i < foo.length(); i++)
{
    String subString = foo.substring(i, i+1);
    cp.append(subString);
    pause(50);
}