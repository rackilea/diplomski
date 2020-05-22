public enum Service {
    INSTANCE;

    private ThirdPartyService service = new ThirdPartyService();

    public ThirdPartyService getService() {
        return service;
    }
}