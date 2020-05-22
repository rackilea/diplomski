String lines[]  = {"ABCD$","ABC[$]D$","[$]ABCDEFG$","!@#%^&*[$]^%$","AB$CD","ABCD","$$ABCD$","AB$[$]CD$"};
String pat = "(?=.{4,35}$)(?:\\[\\$]|[^$])*\\$";
for(String line : lines)
{
    System.out.println(line + ": " + line.matches(pat));
}