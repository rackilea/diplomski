PortletRequest request = (PortletRequest) FacesContext.getCurrentInstance()
                                                          .getExternalContext()
                                                          .getRequest();
    PortletSession session = request.getPortletSession(false);
    if (session == null) {
        return null;
    }
    else {
        return session.getAttribute("foo", PortletSession.APPLICATION_SCOPE);
    }