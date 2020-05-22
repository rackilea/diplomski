@Component
@Scope("prototype")
public class AContainer {

    @Autowired
    private PartA partA;
    @Autowired
    private PartB partB;
    @Autowired
    private BeanFactory beanFactory;

    @PostConstruct
    public void init() {
        PartX partX = beanFactory.getBean("partX"); //name assumed
        partA.setPartX(partX);
        partB.setPartX(partX);
    }
    //rest of your code...
}