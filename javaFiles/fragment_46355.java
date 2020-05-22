@Autowired
private ResourceLoader resourceLoader;

...

final Resource fileResource = resourceLoader.getResource("classpath:XYZ/view/abc.xsd");