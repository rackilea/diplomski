Matcher m = Pattern.compile("\\{([^}]*)\\}").matcher(myString);

while (m.find()) 
{
     myArrayList.add(m.group(1)); 
}