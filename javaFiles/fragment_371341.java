IType [] typeDeclarationList = unit.getTypes();
for (IType typeDeclaration : typeDeclarationList) {
   // Get methods under each type declaration.
   IMethod [] methodList = typeDeclaration.getMethods();
   for (IMethod method : methodList) {
      // Logic here.
   }
}