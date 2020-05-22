@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        A other = (A) obj;
        if (denominator == null) {
            if (other.denominator != null)
                return false;
        } else if (!denominator.equals(other.denominator))
            return false;
        if (numerator == null) {
            if (other.numerator != null)
                return false;
        } else if (!numerator.equals(other.numerator))
            return false;
        return true;
    }