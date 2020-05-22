@Service
public class Service1 {

    private String path = "first path";
    private SupportBean supportBean;

    @Autowired
    public Service1(SupportBean supportBean) {
        this.supportBean = supportBean;
        this.supportBean.setActualPath(this.path);
    }
}