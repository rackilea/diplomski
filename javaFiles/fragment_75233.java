inline fun <reified T : Annotation> Element.getAnnotationClassValue(f: T.() -> KClass<*>) = try { 
    getAnnotation(T::class.java).f() 
    throw Exception("Expected to get a MirroredTypeException")
} catch (e: MirroredTypeException) {
    e.typeMirror
}