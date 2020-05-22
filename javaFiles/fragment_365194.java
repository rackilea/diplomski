package de.professional_webworkx.ws.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

// under this ApplicationPath Glassfish will 
// load the WebService
@ApplicationPath("/REST")
public class WSConfiguration extends Application {

}