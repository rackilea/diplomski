String inputString = "(cl(A, B, 0.620) :-  /* #pos=1,513 *";
List<String> list = new ArrayList<>();
Matcher m2 = Pattern.compile("\\(.*?\\((.*?)\\)").matcher(inputString);
if (m2.find()) {
    String match = m2.group(1);
    String[] parts = match.split(",\\s+");
    for (String part : parts) {
        list.add(part);
        System.out.println("Found an item: " + part);
    }
}