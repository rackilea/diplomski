public class Regex {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("([\\w\\s]*?) (\\w*?) have (\\w*?) (effect|impact) (on|in) ([\\w\\s]*?)(\\.)");
        String s = "Greenhouse gases can have negative impact on global warming.";
        Matcher m = p.matcher(s);
        if (m.find()) {
            for (int i = 0; i < m.groupCount(); i++) {
                System.out.println("Group " + i + ": " + m.group(i));
            }
        }
    }
}