private static void addAnnotation(final CtClass clazz, final String fieldName, final String annotationName, String member, int memberValue) throws Exception {
    final ClassFile cfile = clazz.getClassFile();
    final ConstPool cpool = cfile.getConstPool();
    final CtField cfield = clazz.getField(fieldName);

    final AnnotationsAttribute attr = new AnnotationsAttribute(cpool, AnnotationsAttribute.visibleTag);
    final Annotation annot = new Annotation(annotationName, cpool);
    annot.addMemberValue(member, new IntegerMemberValue(cpool, memberValue));
    attr.addAnnotation(annot);
    cfield.getFieldInfo().addAttribute(attr);
}