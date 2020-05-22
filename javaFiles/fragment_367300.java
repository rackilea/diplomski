class IntrospectClassMetadata extends BasicTransformerAdapter {
  PassThroughResultTransformer rt = PassThroughResultTransformer.INSTANCE;
  public Object transformTuple(Object[] tuple, String[] aliases) {
    final Object o = rt.transformTuple(tuple, aliases);
    ClassMetadata cm = sf.getClassMetadata(o.getClass());
    List<String> pns = new ArrayList<String>(Arrays.asList(cm.getPropertyNames()));
    Map<String, Object> m = new HashMap<String, Object>();
    for(String pn : pns) {
      m.put(pn, cm.getPropertyValue(o, pn));
    }
    m.put(cm.getIdentifierPropertyName(), cm.getIdentifier(o));
    return m;
  }
}