interface A {
    fun t() = "A"
}

abstract class B : A {
    override fun t() = "B"
}

class C : A, B() {
    //                      v--- error
    override fun t()= super<A>.t();

    //              v--- ok
    fun ok()= super<B>.t();

}