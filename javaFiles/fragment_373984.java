Modifier:
  Annotation | public | protected | private
  static | abstract | final | native | synchronized
  transient | volatile | strictfp

ClassOrInterfaceDeclaration:
        {Modifier} (ClassDeclaration | InterfaceDeclaration)

ClassBodyDeclaration:
        {Modifier} MethodOrFieldDecl

MethodOrFieldDecl:
        Type Identifier MethodOrFieldRest