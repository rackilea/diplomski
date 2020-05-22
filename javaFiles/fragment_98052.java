class obj {
    String value;    
    public obj(String value) {
        this.value = value;
    }    
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.value);
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
        final obj other = (obj) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }