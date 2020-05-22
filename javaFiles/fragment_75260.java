//in findConstructor
MethodHandle h = LOOKUP.findConstructor(matcherClass, CONSTRUCTOR_TYPE);
return h.asType(h.type().changeReturnType(PathMatcher.class));

//in getPathMatcher
return (PathMatcher)handleMap.get(c).invokeExact(arg);