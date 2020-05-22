protected void initHandlerMethods() {
        if (logger.isDebugEnabled()) {
            logger.debug("Looking for request mappings in application context: " + getApplicationContext());
        }

        String[] beanNames = (this.detectHandlerMethodsInAncestorContexts ?
                BeanFactoryUtils.beanNamesForTypeIncludingAncestors(getApplicationContext(), Object.class) :
                getApplicationContext().getBeanNamesForType(Object.class));

        for (String beanName : beanNames) {
            if (isHandler(getApplicationContext().getType(beanName))){
                detectHandlerMethods(beanName);
            }
        }
        handlerMethodsInitialized(getHandlerMethods());
    }