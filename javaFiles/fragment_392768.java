String portletResource = ParamUtil.getString(
        actionRequest, "portletResource");

 PortletPreferences portletPreferences =
        PortletPreferencesFactoryUtil.getPortletSetup(
            actionRequest, portletResource);

 portletPreferences .getValue("mailAddress", "default");