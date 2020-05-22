public static String getCSV(int start, int end) {
    List<String> list = IntStream.range(start, end).boxed()
       .map(i -> i.toString()).collect(Collectors.toList());
    String csv = String.join(" ", list);

    return csv;
}

public static void main(String args[])
{
    String input = "1, 2, 3, 4.. 9, 10,13.. 17, 18, 19.. 25";
    input = input.replaceAll(",\\s*", " ");
    Pattern r = Pattern.compile("(\\d+)\\.\\.\\s*(\\d+)");
    Matcher m = r.matcher(input);
    StringBuffer stringBuffer = new StringBuffer();
    while (m.find( )) {
        int start = Integer.parseInt(m.group(1));
        int end = Integer.parseInt(m.group(2));
        m.appendReplacement(stringBuffer, getCSV(start, end+1));
    }
    System.out.println(stringBuffer);
}