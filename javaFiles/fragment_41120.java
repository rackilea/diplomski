@Component
public static class Test2 {
    @Autowired public Test2(@Value("${foo.bar}") List<String> bar) {
        System.out.println("######## @Value " + bar);
    }
}