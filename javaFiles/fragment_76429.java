Context context = (Context) wrapper.getParent();
Wrapper newWrapper = context.createWrapper();
newWrapper.setName(name);
newWrapper.setLoadOnStartup(1);
newWrapper.setServletClass(servletClass);
context.addChild(newWrapper);
context.addServletMapping(pattern, name);