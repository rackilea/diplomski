Service service  = Service.create(
                    new URL(**"file:///C:/reportingService.wsdl"**), 
                    new QName("http://services.app/", "ReportingService")
               );

// ...

binding.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "myuser");   
binding.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "mypasswd");