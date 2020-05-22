public static void main(String[] args) {
    String input = "11B,11A,12,12/1,13,14,15,16,16A,17,17/1,57-51B,57,57-51A,1,10,11,53B,53A,53C,57-51C,57A";
    List<String> items = Arrays.asList(input.split("\\s*,\\s*"));


    Collections.sort(items, new Comparator<String>() {
        public int compare(String o1, String o2) {

            String o1StringPart = o1.replaceAll("\\d", "");
            String o2StringPart = o2.replaceAll("\\d", "");


            if(o1StringPart.equalsIgnoreCase(o2StringPart))
            {
                return extractInt(o1) - extractInt(o2);
            }
            return o1.compareTo(o2);
        }

        int extractInt(String s) {
            String num = s.replaceAll("\\D", "");
            // return 0 if no digits found
            return num.isEmpty() ? 0 : Integer.parseInt(num);
        }
    });

    for (String s : items) {
        System.out.println(s);
    }
}