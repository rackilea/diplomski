// returns something like "Map<K, V>", this is NOT what you want!
DeclaredType classType = (DeclaredType) typeElement.asType();

Types types = processingEnvironment.getTypeUtils();
Elements elements = processingEnvironment.getElementUtils();

// this obtains raw type (plain "Map"), with all methods type-erased,
// the compiler is much better at solving type riddles than you!
DeclaredType rawType = types.getDeclaredType(typeElement);

final Collection<? extends ExecutableElement> methods =
    ElementFilter.methodsIn(elements.getAllMembers(typeElement));

// To create a MethodSpec, suitable for the raw type, you should 
// call 3-parameter MethodSpec#overriding with type-erased raw class type
// as second parameter and javax.lang.model.util.Types instance as third
MethodSpec newMethod = MethodSpec.overriding(methods.get(0), rawType, types);