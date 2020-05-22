public class PageModelInterceptor extends HandlerInterceptorAdapter {
    private MessagingService mailboxService;

    public PageModelInterceptor() {
    }

    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final ModelAndView modelAndView) {
        addNbConversationUpdates(request);
    }

    private void addNbConversationUpdates(final HttpServletRequest request) {
        if (XSecurity.principal() != null) {
            final int nbUpdatedConversations = mailboxService.getUpdatedConversations(XSecurity.principal().getId()).size();
            request.setAttribute("nbConversationUpdates", nbUpdatedConversations);
        }
    }

    public void setMailboxService(final MessagingService mailboxService) {
        this.mailboxService = mailboxService;
    }
}