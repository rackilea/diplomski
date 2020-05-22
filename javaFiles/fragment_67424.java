// Portlet A 
portletRequest.getPortletSession(true)
    .setAttribute("LIFERAY_SHARED_" + CONSTANTS.ATTR_NAME, "value", 
                  PortletSession.APPLICATION_SCOPE);

// Portlet B (in a different WAR) 
String attrValue = portletRequest.getPortletSession(true)
    .getAttribute("LIFERAY_SHARED_" + CONSTANTS.ATTR_NAME, 
                  PortletSession.APPLICATION_SCOPE);