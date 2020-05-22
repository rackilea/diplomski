@Service
public class HSService {
    @Autowired
    private WebServiceTemplate webServiceTemplate;


    public List<HSChild> getHSChildren(String hscode, String country,String limit) {

        GetHSChildren getHSChildren= new ObjectFactory().createGetHSChildren();

        getHSChildren.setCountry(country);
        getHSChildren.setHsCode(hscode);
        getHSChildren.setLimit(Integer.parseInt(limit));

        GetHSChildrenResponse response = (GetHSChildrenResponse) webServiceTemplate.marshalSendAndReceive(getHSChildren);

        return response.getGetHSChildrenReturn();
    }


    public static void main(String[] args) {
        ApplicationContext context = new    ClassPathXmlApplicationContext("applicationContext.xml");
        HSService hsService = context.getBean(HSService.class);
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getHSChildrenReturn"
})
@XmlRootElement(name = "getHSChildrenResponse")
public class GetHSChildrenResponse {

    @XmlElement(required = true)
    protected List<HSChild> getHSChildrenReturn;

    public List<HSChild> getGetHSChildrenReturn() {
        if (getHSChildrenReturn == null) {
            getHSChildrenReturn = new ArrayList<HSChild>();
        }
        return this.getHSChildrenReturn;
    }