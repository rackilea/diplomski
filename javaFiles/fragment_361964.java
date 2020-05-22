class UnmodifiedDog extends Dog {
    public UnmodifiedDog(double age, String name) {
        super.setAge(age);
        super.setName(name);
    }
    @Override
    public void setAge(double age) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setName(String name) {
         throw new UnsupportedOperationException();
    }   
}