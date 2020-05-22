String line = "36-B";
Pattern pattern = Pattern.compile("(\\d*)(.+)(\\d*)");
Matcher matcher = pattern.matcher(line);

while (matcher.find()) 
{
    System.out.println("First captured group: " + matcher.group(1));
    System.out.println("Second captured group: " + matcher.group(2));
    System.out.println("Thisr captured group: " + matcher.group(3));
}