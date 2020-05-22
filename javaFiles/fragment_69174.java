public class AccessibilityPhaseListener implements PhaseListener{
    private static final long serialVersionUID = 1L;

    @Override
    public void beforePhase(PhaseEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)context.getExternalContext().getSession(false);
        if(session==null) {
            return;
        }
        Boolean acessibilityMode = (Boolean)session.getAttribute("AcessibilityMode");
        if(acessibilityMode==null || !acessibilityMode)
            return;

        String viewId = context.getViewRoot().getViewId();
        if(acessibilityMode) {
            int index = viewId.lastIndexOf("/");
            viewId = viewId.substring(0, index+1)+"ac/"+viewId.substring(index+1);
        } else {
            int index = viewId.lastIndexOf("/");
            if(viewId.substring(index-3, index).equals("/ac"))
                viewId = viewId.substring(0, index-3)+viewId.substring(index);
        }

        URL url = null;
        try {
            url = context.getExternalContext().getResource(viewId);
        } catch (MalformedURLException e) {
        }

        if(url==null)
            return;
        ViewHandler handler = context.getApplication().getViewHandler();
        UIViewRoot root = handler.createView(context, viewId);

        root.setViewId(viewId);
        context.setViewRoot(root);
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }
}