public class Test {    
    public static final void main(String[] args) {
        List<String> list = Arrays.asList("b", "c", "a");

        Set<String> linkedSet = 
            list.stream().collect(Collectors.toCollection(LinkedHashSet::new));

        Set<String> collectorToSet = 
            list.stream().collect(Collectors.toSet());

        System.out.println(linkedSet); //[b, c, a]
        System.out.println(collectorToSet); //[a, b, c]
    }
}