interface GrandParent {
    fun foo() = "bar";
}

interface Parent : GrandParent {
    override fun foo(): String;
}

//     v--- must implements abstract foo() method in Parent interface
class Child : Parent;