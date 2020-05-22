String input = "Graaf Karel De Goedelaan 1 8500 Kortrijk";
String[] results = input.split("([0-9]{4})");
String road = results[0].trim();
String city = results[1].trim();
String postcode = "";
Pattern p = Pattern.compile("([0-9]{4})");
Matcher m = p.matcher(input);
while(m.find()) {
    postcode = m.group(1);
}
System.out.println(input);
System.out.println("Road: " + road);
System.out.println("Postcode: " + postcode);
System.out.println("City: " + city);