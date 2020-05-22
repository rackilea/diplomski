fun getData(x: Any): String? {
    if (x is Array<*> && x.isArrayOf<String>()) {
        return x[0] as String
    }
    return null
}