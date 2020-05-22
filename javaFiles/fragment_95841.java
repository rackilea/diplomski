public class ClassBasedEdgeFactory<V, E> implements EdgeFactory<V, E>, ...
{
    ...
    private final Class<? extends E> edgeClass;

    public ClassBasedEdgeFactory(Class<? extends E> edgeClass)
    {
        this.edgeClass = edgeClass;
    }

    ...    
    @Override public E createEdge(V source, V target)
    {
        try {
            return edgeClass.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Edge factory failed", ex);
        }
    }
}