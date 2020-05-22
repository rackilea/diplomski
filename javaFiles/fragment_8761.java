@Override
public void dispose() {
    if (disposed) { // nothing to do
        return;
    }
    OpenHashSet<Disposable> set; // this is the same type as our field that holds the Disposables
    synchronized (this) {
        if (disposed) { 
            return; // another thread did it while we got our lock, so nothing to do
        }
        disposed = true; // setting this flag is safe now, we're the only ones disposing
        set = resources; // the references are now in this local variable
        resources = null; // our field no longer has the references
    }

    dispose(set); // from here on out, only this method has the references to the Disposables
}