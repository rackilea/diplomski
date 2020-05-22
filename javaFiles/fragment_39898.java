package mx.gob.jgtjo.apps.schedule.web.conversation;

import javax.servlet.http.HttpServletRequest;

import mx.gob.jgtjo.apps.schedule.web.utils.JsfUtils;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.hibernate.context.CurrentSessionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConversationalCurrentSessionContext implements CurrentSessionContext {

    private static final long serialVersionUID = 803157986557235023L;

    protected static final Logger log = LoggerFactory
            .getLogger(ConversationalCurrentSessionContext.class);

    public ConversationalCurrentSessionContext() {

    }

    @Override
    public Session currentSession() throws HibernateException {

        HttpServletRequest request = null;

        try {
            request = JsfUtils.getCurrentHttpRequest();
        } catch (Exception e) {
            log.debug("No current http request in faces context, returning default conversation.");
        }

        if (request == null) {
            return (Session) ConversationManager.getDefaultConversationSession();
        } else {
            return (Session) ConversationManager.getSessionForRequest(request);
        }
    }
}