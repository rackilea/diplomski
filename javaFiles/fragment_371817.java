String nsURI = "";
    for(Annotation annotation: jaxbObject.getClass().getPackage().getAnnotations()){
        if(annotation.annotationType() == XmlSchema.class){
            nsURI = ((XmlSchema)annotation).namespace();
            break;
        }
    }