webAppContext.setConfigurations (new Configuration []
{
        new AnnotationConfiguration() 
        {
            @Override
            public void configure(WebAppContext context) throws Exception
            {
                boolean metadataComplete = context.getMetaData().isMetaDataComplete();
                context.addDecorator(new AnnotationDecorator(context));   

                AnnotationParser parser = null;
                if (!metadataComplete)
                {
                    if (context.getServletContext().getEffectiveMajorVersion() >= 3 || context.isConfigurationDiscovered())
                    {
                        parser = createAnnotationParser();
                        parser.registerAnnotationHandler("javax.servlet.annotation.WebServlet", new WebServletAnnotationHandler(context));
                        parser.registerAnnotationHandler("javax.servlet.annotation.WebFilter", new WebFilterAnnotationHandler(context));
                        parser.registerAnnotationHandler("javax.servlet.annotation.WebListener", new WebListenerAnnotationHandler(context));
                    }
                }

                List<ServletContainerInitializer> nonExcludedInitializers = getNonExcludedInitializers(context);
                parser = registerServletContainerInitializerAnnotationHandlers(context, parser, nonExcludedInitializers);

                if (parser != null)
                {
                    parseContainerPath(context, parser);
                    parseWebInfClasses(context, parser);
                    parseWebInfLib (context, parser);
                    parseHostClassPath(context, parser);
                }                  
            }

            private void parseHostClassPath(final WebAppContext context, AnnotationParser parser) throws Exception
            {
                clearAnnotationList(parser.getAnnotationHandlers());
                Resource resource = getHostClassPathResource(getClass().getClassLoader());                  
                if (resource == null)
                    return;

                parser.parse(resource, new ClassNameResolver()
                {
                    public boolean isExcluded (String name)
                    {           
                        if (context.isSystemClass(name)) return true;                           
                        if (context.isServerClass(name)) return false;
                        return false;
                    }

                    public boolean shouldOverride (String name)
                    {
                        //looking at webapp classpath, found already-parsed class of same name - did it come from system or duplicate in webapp?
                        if (context.isParentLoaderPriority())
                            return false;
                        return true;
                    }
                });

                //TODO - where to set the annotations discovered from WEB-INF/classes?    
                List<DiscoveredAnnotation> annotations = new ArrayList<DiscoveredAnnotation>();
                gatherAnnotations(annotations, parser.getAnnotationHandlers());                 
                context.getMetaData().addDiscoveredAnnotations (annotations);
            }

            private Resource getHostClassPathResource(ClassLoader loader) throws IOException
            {
                if (loader instanceof URLClassLoader)
                {
                    URL[] urls = ((URLClassLoader)loader).getURLs();
                    for (URL url : urls)
                        if (url.getProtocol().startsWith("file"))
                            return Resource.newResource(url);
                }
                return null;                    
            }
        },
    });