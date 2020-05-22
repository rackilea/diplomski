@Component
public class SomeBean {

    private FirstBean fb;

    @Autowired
    public SomeBean(FirstBean firstBean) {
        this.fb = firstBean;
        this.fb.setName("Some Name");
    }

    public void print() {
        this.fb.toString();
    }
}