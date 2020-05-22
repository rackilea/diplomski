public class MutableTuple4<A, B, C, D> { 

    private static final long serialVersionUID = 1L;

    public A first; 
    public B second; 
    public C third; 
    public D fourth; 

    public MutableTuple4(A a, B b, C c, D d) { 
        this.first = a; 
        this.second = b; 
        this.third = c;
        this.fourth = d;
    } 

    public A getFirst() {
        return this.first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    // remaining getters and setters here...
    // etc...

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.first);
        hash = 23 * hash + Objects.hashCode(this.second);
        hash = 23 * hash + Objects.hashCode(this.third);
        hash = 23 * hash + Objects.hashCode(this.fourth);
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
        final Tuple<A, B, C, D> other = (Tuple<A, B, C, D>) obj;
        if (!Objects.equals(this.first, other.first)) {
            return false;
        }
        if (!Objects.equals(this.second, other.second)) {
            return false;
        }
        if (!Objects.equals(this.third, other.third)) {
            return false;
        }
        if (!Objects.equals(this.fourth, other.fourth)) {
            return false;
        }
        return true;    
    } 

}