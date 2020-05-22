ServiceFactory factory1 = ServiceFactory.newInstance();
    QName qnTick = new QName("http://soapinterop.org/xsd", "ArrayOfString");
    Service serviceTickReq = factory1.createService(qnTick);
    // Service serviceTickReq = new org.apache.axis.client.Service();
    TypeMappingRegistry tmr = (TypeMappingRegistry) serviceTickReq
            .getTypeMappingRegistry();
    TypeMapping tm = (TypeMapping) tmr.getDefaultTypeMapping();
    tm.register(ArrayOfString.class, qnTick, new BeanSerializerFactory(
            ArrayOfString.class, qnTick), new BeanDeserializerFactory(
            ArrayOfString.class, qnTick));

    TypeMappingRegistry tmr1 = (TypeMappingRegistry) serviceTickReq
            .getTypeMappingRegistry();
    TypeMapping tm1 = (TypeMapping) tmr1.getDefaultTypeMapping();
    tm1.register(String[].class, qnTick, new BeanSerializerFactory(
            String[].class, qnTick), new BeanDeserializerFactory(
            String[].class, qnTick));