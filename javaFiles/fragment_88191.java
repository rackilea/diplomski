//replaces all escaped pipes to a temporary replacement
string = string.replaceAll("\\\\\\|", "tmpReplacement");

//iterate through all parts of the string which is divided by a pipe
for(String str : string.split("\\|"))
{
     str = str.replaceAll("tmpReplacement" , "\\|"/*or how you need it*/);
     //now you can use str; str is each part of the variable string, which has not been escaped
}