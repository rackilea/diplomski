private Map<String,WeakReference<String>> myInternMap = new WeakHashMap<String,,WeakReference<String>>();
public String intern(String value) {
  synchronized(myInternMap) {
    WeakReference<String> curRef = myInternMap.get(value);
    String curValue = ((curRef != null) ? curRef.get() : null);
    if(curValue != null) {
      return curValue;
    }

    myInternMap.put(value, new WeakReference<String>(value));
    return value;
  }
}