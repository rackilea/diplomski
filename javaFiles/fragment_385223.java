Object[] containedValues;
 if (ref instanceof Collection)
     containedValues = ((Collection)ref).toArray();
 else if (ref instanceof Map)
     containedValues = ((Map)ref).values().toArray();
 else if (ref instanceof Object[])
     containedValues = (Object[])ref;
 else if (ref instanceof SomeOtherCollectionTypeISupport)
     ...