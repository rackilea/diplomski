public static void main(String args[]) {

    ArrayList<String[]> teamsToOrder = new ArrayList<String[]>();
    String[] array1 = {"340","100"};
    String[] array2 = {"7680","70"};
    String[] array3 = {"770","110"};

    teamsToOrder.add(array1);teamsToOrder.add(array2);teamsToOrder.add(array3);

    Collections.sort(teamsToOrder,new Comparator<String[]>() {
        public int compare(String[] s1, String[] s2) {

            return Integer.parseInt(s2[1]) - Integer.parseInt(s1[1]);
        }
    });

    // display the new sorted ArrayList of String arrays:
    for (String[] s: teamsToOrder) {
        System.out.println(Arrays.toString(s));
    }
}