public class Helloworldcontroller {
    private final Helloworldservice hservice;

    public Helloworldcontroller(Helloworldservice hservice) {
        this.hservice = hservice;
    }

    public String sayHello() {
        return hservice.greeting();
    }

    public String sayHelloSB() {
        Map<String, String> sb = new HashMap<String, String>();
        sb.put("name", "somebody");
        return hservice.greetingSB(sb);
    }
}