SSOAgentConfig ssoAgentConfig = (SSOAgentConfig) request.
    getAttribute(SSOAgentConstants.CONFIG_BEAN_NAME);
if (ssoAgentConfig == null) {
    throw new SSOAgentException("Cannot find " + SSOAgentConstants.CONFIG_BEAN_NAME +
        " set a request attribute. Unable to proceed further");
}