public class AcceptAllClassFilter implements StoredClassFilter {

    @Override
    public boolean accept(StoredClass storedClass) {
        return true;
    }
}