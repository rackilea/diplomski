ClassInstanceCreationExpression:
  UnqualifiedClassInstanceCreationExpression
  ExpressionName . UnqualifiedClassInstanceCreationExpression
  Primary . UnqualifiedClassInstanceCreationExpression

UnqualifiedClassInstanceCreationExpression:
  new [TypeArguments] ClassOrInterfaceTypeToInstantiate ( [ArgumentList] ) [ClassBody]

ClassOrInterfaceTypeToInstantiate:
  {Annotation} Identifier {. {Annotation} Identifier} [TypeArgumentsOrDiamond]

TypeArgumentsOrDiamond:
  TypeArguments 
  <>