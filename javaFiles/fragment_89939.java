class A implements C extends Z { 

    private StatucBType getSatusA() {...} 

    @Override
    public StatusEntry getServiceStatus() throws Exception {
        return getServiceStatus(this::getStatusA);
    }

}