// User credentials.
parameters.put(SessionParameter.USER, "admin");
parameters.put(SessionParameter.PASSWORD, "admin");

// Connection settings.
parameters.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());
parameters.put(SessionParameter.ATOMPUB_URL, "http://localhost:8080/alfresco/service/cmis"); // URL to your CMIS server.
parameters.put(SessionParameter.AUTH_HTTP_BASIC, "true" );
parameters.put(SessionParameter.COOKIES, "true" );

// Create session.
// Alfresco only provides one repository.
Repository repository = sessionFactory.getRepositories(parameters).get(0);
Session session = repository.createSession();