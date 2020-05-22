class myService {
    def myRemoteService
    static transactional = false

    private MyRemoteService getService(String remoteServiceURL) {
        HessianProxyFactory factory = new HessianProxyFactory();
        try {
            return (MyRemoteService) factory.create(MyRemoteService.class, url);
        }
        catch (MalformedURLException e) {
            e.printStackTrace()
        }
        return null
    }

    def someRemoteMethod(String remoteServiceURL) {
        getService(remoteServiceURL).myRemoteMethod()
    }
}