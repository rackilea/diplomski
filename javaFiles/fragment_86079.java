Digester digester = new Digester();
    digester.setValidating( false );
    digester.addObjectCreate("response", Response.class );
    digester.addBeanPropertySetter("response/total", "total" );
    digester.addCallMethod("response/warning", "addWarning", 1);
    digester.addCallParam("response/warning", 0);