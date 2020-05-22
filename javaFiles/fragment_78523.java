// ClassSymbol cs is from super.loadClass
        // Context context is same as used for creating the compiler
        Type.ClassType newClassType = new Type.ClassType(Type.noType, List.<Type>nil(), cs);
        cs.type = newClassType;
        newClassType.tsym = cs;
        Names names = Names.instance(context);
        Symtab symtab = Symtab.instance(context);
        newClassType.supertype_field = symtab.objectType;
        cs.kind = Kinds.TYP;
        Scope members = new Scope(cs);
        cs.members_field = members;
        Type.MethodType mt = new Type.MethodType(List.<Type>nil(), symtab.voidType, List.<Type>nil(), symtab.methodClass);
        Symbol.MethodSymbol constructor = new Symbol.MethodSymbol(Flags.PUBLIC, names.init, mt, cs);
        members.enter(constructor);