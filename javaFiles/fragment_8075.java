static Parser<Declaration> classDef(Parser<Modifier> mod, Parser<Member> member) {
   return curry(ClassDef.class).sequence(
       mod.many(), term("class"), Terminals.Identifier.PARSER, TYPE_PARAMETERS.optional(),
       term("extends").next(ELEMENT_TYPE_LITERAL).optional(),
       term("implements").next(ELEMENT_TYPE_LITERAL.sepBy1(term(","))).optional(),
       body(member));
 }