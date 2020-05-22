String passableUrl = "http://mymobisite.com/cat.php?id=33";
Matcher idParser = Pattern.compile("\\d{1,5}").matcher(passableUrl);
if (idParser.find())
    System.out.println("idParse: " + idParser.group());
else 
    System.out.println("idParse: No Matches Found.");