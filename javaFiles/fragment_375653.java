public class sample {

    static List<String> values = Arrays.asList("test","best","crest","zest","testy","tether","temper","teat","tempest");

    /**
     * @param args
     */
    public static void main(String[] args) {

        String queryStr = "te*t";
        queryStr = queryStr.replaceAll("\\*", "\\\\w*");
        System.out.println(queryStr);
        System.out.println(query(queryStr));

    }

    public static Collection<String> query(String queryStr) {
        List<String> list = new ArrayList<String>();
        for (String str : values) {
            if (str.matches(queryStr))
                list.add(str);
        }
        if (list.isEmpty())
            return null;
        else
            return list;
    }
}