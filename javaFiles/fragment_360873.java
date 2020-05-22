private static String equivalent(String[] s1, String[] s2) {
    ArrayList<Integer> num1 = new ArrayList<Integer>();
    ArrayList<Integer> num2 = new ArrayList<Integer>();
    for (String str : s1) {
        String[] storage = str.split("#");
        for (String st : storage) {
            num1.add(Integer.parseInt(String.valueOf(st)));
        }
    }
    for (String str : s2) {
        String[] storage = str.split("#");
        for (String st : storage) {
            num2.add(Integer.parseInt(String.valueOf(st)));
        }
    }
    Collections.sort(num1);
    Collections.sort(num2);
    if (num1.equals(num2)) {
        return "yes";
    } else {
        return "no";
    }

}