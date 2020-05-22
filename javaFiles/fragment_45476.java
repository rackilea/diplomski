webClient.setAjaxController(new NicelyResynchronizingAjaxController());
webClient.setAjaxController(new AjaxController(){
    @Override
    public boolean processSynchron(HtmlPage page, WebRequest request, boolean async)
    {
        return true;
    }
});