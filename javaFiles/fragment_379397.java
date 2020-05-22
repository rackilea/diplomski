String str = "Refurbished Engine for 2000cc Vehicles";
Pattern pattern = Pattern.compile("\\d{4}cc");
Matcher matcher = pattern.matcher(str);

StringBuffer result = new StringBuffer();
while (matcher.find()) {
    matcher.appendReplacement(result, matcher.group().toUpperCase());
}

matcher.appendTail(result);

System.out.println(result.toString());