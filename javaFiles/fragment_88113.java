@Service
public class MyService {
    private String field1;
    private String field2;

    private final AnotherService anotherService;

    public MyService(AnotherService anotherService) {
        this.anotherService = anotherService;
        this.anotherService.initField1(field1);
        this.anotherService.initField2(field2);
    }

    public String foo() {
        return field1 + field2;
    }
}