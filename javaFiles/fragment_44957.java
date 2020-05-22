public class JavaApplication39 {

    static String str = "..A 546.88 end.";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a pattern to match breaks
        Pattern p = Pattern.compile("[0-9]+(\\.[0-9][0-9]?)?");
        // Split input with the pattern
        String[] result = p.split(str);
        Matcher m = p.matcher(str);
        ArrayList<String> strings = new ArrayList<>();

        while (m.find()) {//all those that match
            strings.add(m.group());
            //System.out.println(m.group());
        }

        for (int i = 0; i < result.length; i++) {//all those that dont match
            strings.add(result[i].replaceAll("\\.", "").trim());//strip '.' and ' '
            // System.out.println(result[i]);
        }
        //all contents in array
        for (Iterator<String> it = strings.iterator(); it.hasNext();) {
            String string = it.next();
            System.out.println(string);
        }
    }
}