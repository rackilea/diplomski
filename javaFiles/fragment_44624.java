public void selectionListener(AjaxBehaviorEvent event) {
    // ...

    FacesContext context = FacesContext.getCurrentInstance();
    context.getApplication().getNavigationHandler().handleNavigation(context, "#{backingBean.selectionListener}", "success");
}