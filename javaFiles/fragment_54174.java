RuntimeServices runtimeServices = RuntimeSingleton.getRuntimeServices();

        StringReader reader = new StringReader(stringValue);
        SimpleNode node = runtimeServices.parse(reader, "Template name");
        Template template = new Template();
        template.setRuntimeServices(runtimeServices);
        template.setData(node);
        template.initDocument();