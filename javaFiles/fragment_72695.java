@Autowired
private AnotherBean anotherBean;

@PostConstruct
public void init(){
    location = anotherBean.getLocation();
    enabled = anotherBean.isEnabled();
}