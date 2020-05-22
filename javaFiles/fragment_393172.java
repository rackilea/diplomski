Package:
 'package' name=ID; imports=Import typeDefinition=TypeDefinition;

Import:
 'import' importedNamespace=[TypeDefinition|QualifiedName] ';'
;

TypeDefinition:
  InterfaceDefinition | EnumDefinition ...
;

InterfaceDefinition:
 qualifier=Qualifier !name=ID
;