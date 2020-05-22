class MyController{

    @Resource
    private ReportFactory reportFactory;

    public HttpResponse getReport(@RequestParam("type") ReportType type){
        reportFactory.forType(type);
    }

}