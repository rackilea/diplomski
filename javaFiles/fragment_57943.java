private final FooService fooService;

@Autowired
public MyComponent(FooService fooService) {
    this.fooService = fooService;
}