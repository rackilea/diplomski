public void add(T object) {
    synchronized (mLock) {
        if (mOriginalValues != null) {
            mOriginalValues.add(object);
        } else {
            mObjects.add(object);
        }
    }
    if (mNotifyOnChange) notifyDataSetChanged();
}