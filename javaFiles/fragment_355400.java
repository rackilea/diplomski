public final Map getParameterValues() {
    final Map values = new HashMap();

    final IViewDescriptor[] views = PlatformUI.getWorkbench()
            .getViewRegistry().getViews();
    for (int i = 0; i < views.length; i++) {
        final IViewDescriptor view = views[i];
        values.put(view.getLabel(), view.getId());
    }

    return values;
}