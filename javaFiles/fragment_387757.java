interface A{
    fun add()
}

class AImpl: A {
    override fun add() {
        println("Hello, Aimpl")
    }
}

val calc = AImpl()
fun op(func: A.()->Unit){
    calc.func()   
}

fun main(args: Array<String>) {
    op(A::add)
}