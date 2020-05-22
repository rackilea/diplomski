getRequestCycleListeners().add(new AbstractRequestCycleListener() {
    @Override
    public IRequestHandler onException(RequestCycle cycle, Exception e) {
        MyException myE = Exceptions.findCause(e, MyException.class);
        if (myE != null) {
            IPageRequestHandler handler = cycle.find(IPageRequestHandler.class);
            if (handler != null) {
                if (handler.isPageInstanceCreated()) {
                    WebPage page = (WebPage)(handler.getPage());

                    page.error(page.getString(myE.getCode()));

                    return new RenderPageRequestHandler(new PageProvider(page));
                }
        }

        return null;
    }
});