public class Test1 {
    @Autowired
    Properties props;

    public void printProps() {
        for(Entry<Object, Object> e : props.entrySet()) {
            System.out.println(e);
        }
    }