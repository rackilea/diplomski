RestTemplate restTemplate = new RestTemplate();
List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
for (int i = 0; i != converters.size(); i++) {
    if (converters.get(i) instanceof Jaxb2RootElementHttpMessageConverter) {
        Jaxb2RootElementHttpMessageConverter xmlConverter = new Jaxb2RootElementHttpMessageConverter(){
            @Override
            protected void customizeMarshaller(Marshaller marshaller) {
                marshaller.setProperty( "com.sun.xml.internal.bind.xmlHeaders", "<!DOCTYPE MyRequest SYSTEM \"MyRequest.dtd\">");
                // add other customizations
            }
        };
        converters.set(i, xmlConverter);
        break;
    }
}