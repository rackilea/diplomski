case QUALIFIED:
    QName typeName = parent.getTypeName();
    if(typeName!=null) {
        uri = typeName.getNamespaceURI();
    } else {
        uri = xs.namespace();
    }
    if(uri.length()==0) {
        uri = parent.builder.defaultNsUri;
    }
    break;