ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);

Object bean = context.getBean(some.thing.Else.class);

Context initCtx = new InitialContext();
Context springCtx = initCtx.createSubcontext("spring");

springCtx.bind("bean", bean);