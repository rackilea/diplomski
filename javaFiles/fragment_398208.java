Component component = (...)

// HTTPS
VirtualHost hostHttps
      = new VirtualHost(component.getContext());
component.getHosts().add(hostHttps);
hostHttps.setHostScheme("https");

Restlet restletSecure = (...)
hostHttps.attachDefault(restletSecure);

// HTTP
VirtualHost hostHttp
      = new VirtualHost(component.getContext());
component.getHosts().add(hostHttp);
hostHttp.setHostScheme("http");

Restlet restletUnsecure = (...)
hostHttp.attachDefault(restletUnsecure);