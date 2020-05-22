class Greeter(message: String) {
    def SayHi() = println(message)
}

val greeter = new Greeter("Hello world!")
greeter.SayHi()