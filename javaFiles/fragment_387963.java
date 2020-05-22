public class A implements Comparable<A>{
    private String key;

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (!(obj instanceof A)) return false;

        A that = (A)obj;
        return this.key.equals(that.key);    
    }

    @Override
    public int hashCode(){
        return key.hashCode();
    }

    @Override
    public int compareTo(A that){
        //returns -1 if "this" object is less than "that" object
        //returns 0 if they are equal
        //returns 1 if "this" object is greater than "that" object
        return this.key.compareTo(that.key);
    }
}