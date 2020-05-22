@Component
class Invoker {
   private String[] args = new String[]("1","2","3")

   @Autowired
   private Invoked invoked;

   @PostConstruct
   private void init() {
      invoked.method(args);
   } 

}