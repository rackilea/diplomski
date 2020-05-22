// change the parameter type to `Callable` ---v
fun convertExceptionToEmpty(requestFunc: Callable<List<Widget>>): Stream<Widget> {
    try {
        //                 v--- get the `List<Widget>` from `Callable`
        return requestFunc.call().stream()
    } catch (th: Throwable) {
        return Stream.empty()
    }
}