@SuppressWarnings("unchecked")
@Override
public <T> T getAdapter(Class<T> required) {

    if (IFindReplaceTarget.class.equals(required)) {
        return (T) ... your find replace target class
    }

    ... other adapters
}