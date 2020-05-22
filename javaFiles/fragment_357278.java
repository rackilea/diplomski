public class LogoutAction extends org.apache.struts.action.Action {

private Log log_db = LogFactory.getLog("mysql");

public ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {

    log_db.debug("User: "+request.getRemoteUser()+" logged off");
    request.getSession().invalidate();
    your
}