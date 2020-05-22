WeakReference<Object> ref = cache.get(obj);
Object cached = (ref != null) ? ref.get() : null;
if (cached != null) {
    return cached;
}
else {
    cache.put(obj, new WeakReference(obj));
    return obj;
}