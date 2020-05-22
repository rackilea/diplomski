class Employee{
    int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        //see comments below for this next line
        if (o.getClass() != this.getClass()) return false;
        Employee other = (Employee)o;
        return other.id == this.id;
    }
}