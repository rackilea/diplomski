String text = "/api/v2/client/domain/category2/id";
String pattern = "^(/api)?(/v\\d+)?(/[^/]+(?:/[^/]+)*?)??(?:(/category[12])(/.*)?)?$";
Pattern regex = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
Matcher m = regex.matcher(text);

while (m.find())
{
    System.out.println("api: " + m.group(1) + 
                       "\nversion: " + m.group(2) +
                       "\nclient: " + m.group(3) +
                       "\ncategory: " + m.group(4) +
                       "\nextra: " + m.group(5));
}