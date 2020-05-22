//inject the servlet context
@javax.ws.rs.core.Context 
ServletContext servletContext

public InitApplicationContext getInitContext(){
    return (InitApplicationContext)servletContext.getAttribute("initApplicationContext");
}