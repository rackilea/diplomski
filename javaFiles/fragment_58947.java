public class HashCodeWrapper {
    private final int hashCode;
    public HashCodeWrapper(int hashCode){
        this.hashCode = hashCode;
    }
    @Override
    public int hashCode(){
        return hashCode;
    }
    @Override
    public boolean equals(Object o){ return this.hashCode == o.hashCode(); }
}