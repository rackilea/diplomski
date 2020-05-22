ModuleOverviewBean bean = (ModuleOverviewBean) servletContext.getAttribute("modOverview");

if (bean == null) {
    bean = new ModuleOverviewBean();
    servletContext.setAttribute("modOverview", bean);
}

// ...