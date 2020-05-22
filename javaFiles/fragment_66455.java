String data = "{-LS4kp5hQc6Uodf={name=random, suggestion=OK, id=kj61sCceDs34Nr1}}";
Pattern pattern = Pattern.compile("name=(.*),.*suggestion=(.*),");
Matcher matcher = pattern.matcher(data);
if (matcher.find()) {
    System.out.println(matcher.group(1)); //name value
    System.out.println(matcher.group(2));//suggestion value
}