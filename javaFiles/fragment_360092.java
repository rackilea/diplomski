public class OctreeMarshaller<T> implements DataMarshaller<Octree<T>> {

    @Override
    @SuppressWarnings("unchecked")
    public Class<Octree<T>> getDataClass() {
        return (Class<Octree<T>>)(Class<?>)Octree.class;
    }

    [...]
}