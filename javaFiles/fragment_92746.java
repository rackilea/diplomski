@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getEmpId() == employee.getEmpId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmpId());
    }