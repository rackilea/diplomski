public static DeclaredType declaredType(final Element element, final TypeMirror... argumentTypes) {
    return new DeclaredType(){
        @Override public Element asElement() {
            return element;
        }
        @Override public List<? extends TypeMirror> getTypeArguments() {
            return Arrays.asList(argumentTypes);
        }
        @Override public String toString() {
            return format("DeclareTypeModel[element=%s, argumentTypes=%s]",
                    element, Arrays.toString(argumentTypes));
        }
        @Override public <R, P> R accept(TypeVisitor<R, P> v, P p) {
            return v.visitDeclared(this, p);
        }
        @Override public boolean equals(Object obj) { throw new UnsupportedOperationException(); }
        @Override public int hashCode() { throw new UnsupportedOperationException(); }

        @Override public TypeKind getKind() { throw new UnsupportedOperationException(); }
        @Override public TypeMirror getEnclosingType() { throw new UnsupportedOperationException(); }
    };
}