AnnotatedType art = myMethod.getAnnotatedReturnType();
System.out.print(
    Arrays.toString(art.getAnnotations())+" "+art.getType().getTypeName()+" -> ");
final boolean typeVariable = art instanceof AnnotatedTypeVariable;
if(typeVariable) System.out.print('<');
System.out.print(Arrays.toString(((AnnotatedElement)art.getType()).getAnnotations())+" ");
System.out.print(art.getType().getTypeName());
if(typeVariable) {
    AnnotatedTypeVariable atv = (AnnotatedTypeVariable)art;
    AnnotatedType[] annotatedBounds = atv.getAnnotatedBounds();
    if(annotatedBounds.length>0) {
        System.out.print(" extends ");
        for(AnnotatedType aBound: annotatedBounds) {
            System.out.print(Arrays.toString(aBound.getAnnotations())+" ");
            System.out.print(aBound.getType().getTypeName()+", ");
        }
    }
    System.out.println(">");
}