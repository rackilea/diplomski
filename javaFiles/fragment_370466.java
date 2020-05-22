Set<? extends Element> proxyElements = roundEnvironment.getElementsAnnotatedWith(NameToken.class);

    for(Element element : proxyElements){
        TypeElement typeElement = (TypeElement)element;
        DeclaredType declaredType = (DeclaredType)typeElement.getInterfaces().get(0); //assuming there is an interface

        for(TypeMirror genericParameter : declaredType.getTypeArguments()){
            messager.printMessage(Diagnostic.Kind.NOTE, genericParameter.toString());
        }
    }