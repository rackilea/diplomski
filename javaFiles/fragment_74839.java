// mListener is an instance of ListChangeRegistry
@Override
public T set(int index, T object) {
    T val = super.set(index, object);
    if (mListeners != null) {
        mListeners.notifyChanged(this, index, 1);
    }
    return val;
}