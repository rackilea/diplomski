public class MyClass {
    private static void func(ArrayList<String> res, String digits, String s){
        if (digits.isEmpty()) {
            res.add(s.substring(1));
            return;
        }
        func(res, digits.substring(1), s + ',' + digits.charAt(0));
        if (digits.length() >= 2) {
            func(res, digits.substring(2), s + ',' + digits.substring(0, 2));
        }
    }

    public static void main(String args[]) {
        ArrayList<String> res = new ArrayList<>();
        func(res, "1234", "");
        for (String r : res) {
            System.out.println(r);
        }
    }
}