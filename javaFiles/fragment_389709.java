if (!(type instanceof ClassOrInterfaceDeclaration))) {
    continue;
}
ClassOrInterfaceDeclaration classOrInterface = (ClassOrInterfaceDeclaration)type;
if (!classOrInterface.isInterface()) {
    return packagePrefix + type.getName();
}