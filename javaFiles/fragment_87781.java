List<TypeVariable<?>> typeParameters = Arrays.asList(myMethod.getTypeParameters());

for(TypeVariable<?> tv: typeParameters) {
    System.out.print("< "+Arrays.toString(tv.getAnnotations())+" "+tv.getName());
    AnnotatedType[] annotatedBounds = tv.getAnnotatedBounds();
    if(annotatedBounds.length > 0) {
        System.out.print(" extends ");
        for(AnnotatedType aBound: annotatedBounds) {
            System.out.print(Arrays.toString(aBound.getAnnotations())+" ");
            System.out.print(aBound.getType().getTypeName()+", ");
        }
    }
    System.out.print("> ");
}

AnnotatedType art = myMethod.getAnnotatedReturnType();
System.out.print(Arrays.toString(art.getAnnotations())+" ");
int ix = typeParameters.indexOf(art.getType());
if(ix >= 0) System.out.print("[ref to type parameter #"+ix+"] ");
System.out.println(art.getType().getTypeName());