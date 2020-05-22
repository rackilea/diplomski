@Bean
public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
    ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
    Map<String, String> mediaTypes = new HashMap<String, String>();
    mediaTypes.put("xml", "application/xml");
    resolver.setMediaTypes(mediaTypes);

    List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();
    viewResolvers.add(new BeanNameViewResolver());

    resolver.setViewResolvers(viewResolvers);

    return resolver;
}