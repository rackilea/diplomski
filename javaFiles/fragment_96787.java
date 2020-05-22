@Autowired
private ServletContext context;

@Override
public boolean handleRequest(MessageContext messageContext, Object endpoint)
        throws Exception {

    WebApplicationContext applicationContext =
            WebApplicationContextUtils.getWebApplicationContext(context);
    TestIdentitiesService service =
    applicationContext.getBean(TestIdentitiesService.class);