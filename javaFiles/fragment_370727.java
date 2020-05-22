@Service
public class Manager1 {

    private String path = "second path";
    private SupportBean supportBean;

    @Autowired
    public void setSupportBean(SupportBean supportBean) {
        this.supportBean = supportBean;
        this.supportBean.setActualPath(this.path);
    }
}