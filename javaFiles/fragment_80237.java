XStream xstream = new XStream();

    ReflectionProvider rp = xstream.getReflectionProvider();
    if(null != rp)
    {
        System.out.println("Provider class: " + rp.getClass().getName());
        if(rp instanceof Sun14ReflectionProvider)
            System.out.println("Using Sun14ReflectionProvider");
        else if(rp instanceof PureJavaReflectionProvider)
            System.out.println("Using PureJavaReflectionProvider");
    }