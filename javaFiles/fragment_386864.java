public void listen(@Observes SomeEventClass event, EventMetadata meta) {
    Set<Annotation> qualifiers = meta.getQualifiers();
    ChangeType ct = null;
    for (Annotation qualifier : qualifiers) {
       if (qualifier.annotationType().equals(ChangeType.class)) {
                ct = (ChangeType) qualifier;
       }
    }
    if (ct != null)
        //do something with ct.value 
}