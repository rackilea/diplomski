@Value("classpath*:dozer/*.xml")
private List<Resources> resources;

@Bean(name = "org.dozer.Mapper")
public DozerBeanMapper dozerBean() {
   List<String> xmlString = 
           resources.stream()
                    .map(t -> {
                                try {
                                      return t.getFile().toURI().toURL().toString();   
                                    }
                                    catch (IOException e) {
                                      throw new RuntimeException(e);
                                    }
                        })  
                     .collect(Collectors.toList());

    DozerBeanMapper dozerBean = new DozerBeanMapper();
    dozerBean.setMappingFiles(xmlString );
    return dozerBean;
}