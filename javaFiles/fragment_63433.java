public static void main(String[] args) {
    String test = "A1=CA2=BOA2=RA4=OA11=O";
    List<String> allMatches = new ArrayList<String>();
    Matcher m = Pattern.compile("(a\\d+)", Pattern.CASE_INSENSITIVE).matcher(test);

    while (m.find()) {
       allMatches.add(m.group());
    }
}