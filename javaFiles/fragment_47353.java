ContextHandlerCollection contexts = new ContextHandlerCollection();
server.setHandler(contexts);

ContextHandler stock = new ContextHandler("/stock");
stock.setHandler(new Class2HTTPMessageHandler());
contexts.add(stock);