@Override
public FieldVisitor visitField(int access, String name, String desc, String signature, Object value){
    System.out.println("visitField: access="+access+" name="+name+" desc="+desc+" signature="+signature+" value="+value);
    return new FieldAnnotationScanner();
}

@Override
public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions){
    System.out.println("visitMethod: access="+access+" name="+name+" desc="+desc+" signature="+signature+" exceptions="+exceptions);
    return new MethodAnnotationScanner();
}