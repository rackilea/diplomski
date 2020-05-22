case QUALIFIED:
    uri = parent.getTypeName().getNamespaceURI();
    if(uri.length()==0) {
        uri = parent.builder.defaultNsUri;
    }
    break;