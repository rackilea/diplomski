public boolean sameValueAs(ComplexNumber other) {
        if (other == null) return false; 
        if (Double.doubleToLongBits(this.real) != Double.doubleToLongBits(other.real)) return false;
        return Double.doubleToLongBits(this.imag) == Double.doubleToLongBits(other.imag);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (!(obj instanceof ComplexNumber)) return false;
        return sameValueAs((ComplexNumber) obj));
    }