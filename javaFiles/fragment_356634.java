private class MyIntrospector : JacksonAnnotationIntrospector() {
    override fun <A : Annotation> _findAnnotation(
            annotated: Annotated,
            annoClass: Class<A>
    ): A? {
        if (annoClass == JsonIgnore::class.java && _hasAnnotation(annotated, MyJsonIgnore::class.java)) {
            val mji = _findAnnotation(annotated, MyJsonIgnore::class.java)
            if (mji?.value == true) {
                return mji.jsonIgnore as A // this cast should be safe because we have checked
                                           // the annotation class
            }
        }
        return super._findAnnotation(annotated, annoClass)
    }
}