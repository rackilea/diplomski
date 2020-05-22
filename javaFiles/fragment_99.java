public class X<T>  {

    public T[] arrayCreation() {       
        T[] array = (T[]) Array.newInstance(this.getClass(),4); 
    }
}