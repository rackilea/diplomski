JCClassDecl body = null;
if (token.kind == LBRACE) {
    JCModifiers mods1 = F.at(Position.NOPOS).Modifiers(Flags.ENUM | Flags.STATIC);
    List<JCTree> defs = classOrInterfaceBody(names.empty, false);
    body = toP(F.at(identPos).AnonymousClassDef(mods1, defs));
}
if (args.isEmpty() && body == null)
    createPos = identPos;
JCIdent ident = F.at(identPos).Ident(enumName);
JCNewClass create = F.at(createPos).NewClass(null, typeArgs, ident, args, body);