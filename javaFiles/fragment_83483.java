class Implementation1 implements TheInterface {

    @Override  
    public void method() throws SpecialException {
        throw new SpecialException();
    }

}