suspend fun sayHello(): String {
    delay(1000)
    return "Hi there"
}

fun sayHelloSingle(): Single<String> = GlobalScope.rxSingle { sayHello() }