@Component
class Test {

    String str;

    @PostConstruct
    private void init() {
        System.out.println(str.length());
    }
}