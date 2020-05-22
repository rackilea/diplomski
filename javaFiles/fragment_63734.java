public static void main(String[ ] args) {
    String test = "hello buddy my name is buddy";
    String[] res = test.split("buddy");
    for (String s: res) {
        System.out.println(s);
    }
}