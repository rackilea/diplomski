@Override
public Object getSystemService(String name) {
    ServiceFetcher fetcher = SYSTEM_SERVICE_MAP.get(name);
    return fetcher == null ? null : fetcher.getService(this);
}



...
service = cache.get(mContextCacheIndex);
if (service != null) {
    return service;
}
...