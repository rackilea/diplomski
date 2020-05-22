public class GsonStream<E extends Serializable>
        implements HttpStream<E> {
    //...
    public void createRequest(E obj)
            throws Exception {
        //...
    }
}