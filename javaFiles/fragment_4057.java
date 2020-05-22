@Service
public class MyService_Impl implements MyService {
    private ResourceLoader resourceLoader;
    private byte[] gifContent;

    @Autowired
    public MyService_Impl (ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public byte[] getMyResource() throws IOException {
        if(gifContent == null ){
        Resource myResource = resourceLoader.getResource("classpath:/static/my-resource.gif");
        InputStream is = myResource.getInputStream();
        gifContent = IOUtils.toByteArray(is);
        }
        return gitContent;
    }
}