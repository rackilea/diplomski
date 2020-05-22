public static void main(String[] args) {
    String res = new Gson().toJson(match("I expect to have {string} with the text {string}(\\?)", "I expect to have 'foo' with the text 'foo'?"));
    System.out.println(res);
    res = new Gson().toJson(match("I expect to have {string} with the text {string}(\\?)", "I expect to have 'foo' with the text 'foo'"));
    System.out.println(res);
    res = new Gson().toJson(match("I wait {int} second(s)(\\?)", "I wait 1 second?"));
    System.out.println(res);
    res = new Gson().toJson(match("I wait {int} second(s)(\\?)", "I wait 1 second"));
    System.out.println(res);
    res = new Gson().toJson(match("I wait {int} second(s)(\\?)", "I wait 2 seconds?"));
    System.out.println(res);
    res = new Gson().toJson(match("I wait {int} second(s)(\\?)", "I wait 2 seconds"));
    System.out.println(res);
    res = new Gson().toJson(match("I wait {int} second(s)(\\?)", "I wait 2 seconds!")); //false
    System.out.println(res);
    res = new Gson().toJson(match("I poc", "I poc"));
    System.out.println(res);
    res = new Gson().toJson(match("If {string} matches {string}, While {string} respects {string} I do with {int} max tries:", "If 'foo' matches '.+', While 'demo.DemoPage-big_title' respects 'This is a demo for NORAUI.*' I do with 3 max tries:"));
    System.out.println(res);
}