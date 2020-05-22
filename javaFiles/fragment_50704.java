public void load(Object objectOrCollection, AttributeGroup group, ClassDescriptor referenceDescriptor, boolean fromFetchGroup) {
  if (objectOrCollection == null || group == null) {
       return;
   }       
   if (objectOrCollection instanceof Collection) {
       Iterator iterator = ((Collection)objectOrCollection).iterator();
       while (iterator.hasNext()) {
           load(iterator.next(), group, referenceDescriptor, fromFetchGroup);
       }
   }//MY CODE STARTS 
    else if(objectOrCollection instanceof Map){
        Map<Object, Object> map = (Map)objectOrCollection;
        Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
          Map.Entry<Object, Object> entry = it.next();
          load(entry.getValue(), group, referenceDescriptor, fromFetchGroup);
        }
   }//MY CODE ENDS
   else {
       ClassDescriptor concreteDescriptor = referenceDescriptor;
       if (concreteDescriptor.hasInheritance() && !objectOrCollection.getClass().equals(concreteDescriptor.getJavaClass())){
           concreteDescriptor = concreteDescriptor.getInheritancePolicy().getDescriptor(objectOrCollection.getClass());
       }
       AttributeGroup concreteGroup = group.findGroup(concreteDescriptor);
       concreteDescriptor.getObjectBuilder().load(objectOrCollection, concreteGroup, this, fromFetchGroup);
   }