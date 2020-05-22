class Sub extends Super {
    public Sub(Super other) {
        super(other);
    }

    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}