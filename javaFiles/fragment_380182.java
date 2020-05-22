@Test
public void test() {
    String test = "speak \"friend\" and \"enter\"";

    Pattern p = Pattern.compile("\".+?\"");
    Matcher m = p.matcher(test);
    while(m.find()){
    System.out.println(m.group().toString().replace("\"", ""));
    }
}