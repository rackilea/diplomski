public class InvokedCommandComponentLogger implements PhaseListener {

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        // NOOP. The view hasn't been restored yet at that point, so the component tree wouldn't be available anyway.
    }

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext context = event.getFacesContext();

        if (context.isPostback()) {
            UICommand component = findInvokedCommandComponent(context);

            if (component != null) {
                String methodExpression = component.getActionExpression().getExpressionString();
                System.out.println("Method expression of the action being invoked: " + methodExpression);
            }
        }
    }

    private UICommand findInvokedCommandComponent(FacesContext context) {
        Map<String, String> params = context.getExternalContext().getRequestParameterMap();
        Set<String> clientIds = new HashSet<>();

        if (context.getPartialViewContext().isAjaxRequest()) {
            clientIds.add(params.get("javax.faces.source")); // This covers <f:ajax> inside UICommand.
        } else {
            for (Entry<String, String> entry : params.entrySet()) {
                if (entry.getKey().equals(entry.getValue())) { // This covers UIForm and UICommand components.
                    clientIds.add(entry.getKey());
                }
            }
        }

        EnumSet<VisitHint> hints = EnumSet.of(VisitHint.SKIP_UNRENDERED);
        final UICommand[] found = new UICommand[1];
        context.getViewRoot().visitTree(VisitContext.createVisitContext(context, clientIds, hints), new VisitCallback() {
            @Override
            public VisitResult visit(VisitContext context, UIComponent target) {
                if (target instanceof UICommand) {
                    found[0] = (UICommand) target;
                    return VisitResult.COMPLETE;
                } else {
                    return VisitResult.ACCEPT;
                }
            }
        });

        return found[0];
    }

}