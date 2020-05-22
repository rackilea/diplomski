class ListTest {

    // ...

}

trait ListPatch {
    def last {
        // ...
    }
}

object Main {
    def main(args: Array[String]) {
        val list = new ListTest() with ListPatch;
        list.add("test")
        println(list.last)
    }
}