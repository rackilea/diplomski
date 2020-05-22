@Before("execution(* de.ac.mis.dao.acDynamicUserSessionFactory.getSessionFactory())")
public void setUsername(JoinPoint joinPoint) {
    acDynamicUserSessionFactory dao = (acDynamicUserSessionFactory) joinPoint.getTarget();
    RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
    String userName = "";
    if (requestAttributes instanceof PortletRequestAttributes) {
        PortletRequest request = ((PortletRequestAttributes) requestAttributes).getRequest();
        userName = request.getRemoteUser();
    } else if (requestAttributes instanceof ServletRequestAttributes) {
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        userName = request.getRemoteUser();
    }
    dao.setUserName(userName);
    this.log.debug("acUserSessionfactory was set for user: " + userName);
}