import grails.converters.JSON
import grails.util.Environment
import javax.servlet.annotation.WebListener
import javax.servlet.http.HttpSession
import javax.servlet.ServletContext
import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener
import javax.websocket.CloseReason
import javax.websocket.EndpointConfig
import javax.websocket.OnClose
import javax.websocket.OnError
import javax.websocket.OnMessage
import javax.websocket.OnOpen
import javax.websocket.server.ServerContainer
import javax.websocket.server.ServerEndpoint
import javax.websocket.Session
import org.apache.log4j.Logger
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.web.json.JSONObject
import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes
import org.springframework.context.ApplicationContext

@ServerEndpoint(value="/ep/maintenance/attendance-monitoring/upload/status", configurator=GetHttpSessionConfigurator.class)
@WebListener
class UploadEndpoint implements ServletContextListener {
    private static final Logger log = Logger.getLogger(UploadEndpoint.class)
    private Session wsSession
    private HttpSession httpSession

    @Override
    void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.servletContext
        ServerContainer serverContainer = servletContext.getAttribute("javax.websocket.server.ServerContainer")

        try {
            if (Environment.current == Environment.DEVELOPMENT) {
                serverContainer.addEndpoint(UploadEndpoint)
            }

            ApplicationContext ctx = (ApplicationContext) servletContext.getAttribute(GrailsApplicationAttributes.APPLICATION_CONTEXT)
            GrailsApplication grailsApplication = ctx.grailsApplication
            serverContainer.defaultMaxSessionIdleTimeout = grailsApplication.config.servlet.defaultMaxSessionIdleTimeout ?: 0
        } catch (IOException e) {
            log.error(e.message, e)
        }
    }

    @Override
    void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

    @OnOpen
    public void onOpen(Session userSession, EndpointConfig config) {
        this.wsSession = userSession
        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName())
    }

    @OnMessage
    public void onMessage(String message, Session userSession) {
        try {
            Map params = new JSONObject(message)
            if(httpSession.status == null) {
                params = [message: "Initializing file upload.",
                    size: 0,
                    token: 0]
                sendMessage((params as JSON).toString())
            }
            else {
                sendMessage((httpSession.status.get(params.token) as JSON).toString())
            }
        }
        catch(IllegalStateException e) {
        }
    }

    @OnClose
    public void onClose(Session userSession, CloseReason closeReason) {
        try {
            userSession.close()
        }
        catch(IllegalStateException e) {
        }
    }

    @OnError
    public void onError(Throwable t) {
        log.error(t.message, t)
    }

    private void sendMessage(String message, Session userSession=null) {
        wsSession.basicRemote.sendText(message)
    }
}