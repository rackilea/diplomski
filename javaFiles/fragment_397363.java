TypeResolver typeResolver = new TypeResolver();
    MemberResolver memberResolver = new MemberResolver(typeResolver);

    ResolvedType type = typeResolver.resolve(ITestDouble.class);
    ResolvedTypeWithMembers members = memberResolver.resolve(type, null, null);
    ResolvedMethod[] methods = members.getMemberMethods();