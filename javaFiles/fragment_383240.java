@Component
@Scope("request")
public class JobEditActionBean {
    @Autowired
    private JobEditDataBean dataBean;
    @PostConstruct
    public void init() {
        // dataBean.youCanUseDataBeanMethodsHereAlready()
    }
}