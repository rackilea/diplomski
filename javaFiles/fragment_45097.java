static class Company {

    public String getName() {
        return name;
    }

    public Set<Company> getSubcontractors() {
        return subcontractors;
    }
    final String name;
    final Set<Company> subcontractors = new HashSet<>();
    public Company(String name) {
        this.name = name;
    }        

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Company other = (Company) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Company{" + "name=" + name + ", subcontractors=" + subcontractors + '}';
    }
}