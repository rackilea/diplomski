Map<String,TclObject> makeMap(Interp interp, TclDict dict) {
    final Map<String,TclObject> map = new HashMap<>();
    TclDict.foreach(interp, null, dict, new TclDict.Visitor() {
        Object visitor(Interp interp, Object accum, TclObject key, TclObject value) {
            map.put(key.toString(), value);
            return accum;
        }
    });
    return map;
}