authenticationSuccessHandler(AjaxAwareAuthenticationSuccessHandler) {
    requestCache = ref('requestCache')
    defaultTargetUrl = conf.successHandler.defaultTargetUrl // '/'
    alwaysUseDefaultTargetUrl = conf.successHandler.alwaysUseDefault // false
    targetUrlParameter = conf.successHandler.targetUrlParameter // 'spring-security-redirect'
    ajaxSuccessUrl = conf.successHandler.ajaxSuccessUrl // '/login/ajaxSuccess'
    useReferer = conf.successHandler.useReferer // false
    redirectStrategy = ref('redirectStrategy')
}