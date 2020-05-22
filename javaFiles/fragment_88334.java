Hashtable<String, String>  hashmajcompte = new Hashtable<String, String>();

       String      ENDPOINT_URL_CloudAgence=Util.getSysProp("address.cloud.agence");
       String BASIC_USER_CloudAgence= Util.getSysProp("login.cloud.agence");
       String BASIC_PWD_CloudAgence=Util.getSysProp("password.cloud.agence");

       JaxWsProxyFactoryBean factoryCloudAgence = new JaxWsProxyFactoryBean();


        factoryCloudAgence.setServiceClass(LdapCloudAgenceWSImpl.class);
        factoryCloudAgence.setAddress(ENDPOINT_URL_CloudAgence);
        LdapCloudAgenceWSImpl serviceCloudAgence = (LdapCloudAgenceWSImpl) factoryCloudAgence.create();

        BindingProvider bpCloudAgence = (BindingProvider)serviceCloudAgence;
        bpCloudAgence.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, BASIC_USER_CloudAgence);
        bpCloudAgence.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, BASIC_PWD_CloudAgence);


    try { 
        serviceCloudAgence.creerMajCompte(login, password, ncli); 
        hashmajcompte.put("Succes", "Succes"); 
    }  

    catch (NamingException_Exception e) 
    {  
        hashmajcompte.put("NamingException_Exception", e.getMessage()); 
    }