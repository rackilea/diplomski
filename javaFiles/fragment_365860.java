class Derived : Base() {
    private var counter = 0

    override val value: List<Int>
        get() {
            ++counter
            return if (counter % 2 == 0)
                ArrayList() else
                LinkedList()
        }
}

val b = Derived()
println(b.value.javaClass) // class java.util.LinkedList
println(b.value.javaClass) // class java.util.ArrayList