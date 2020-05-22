class Main{
    class SomeClass(val x:String) { override def toString:String = x }
    def funct(obj:Object) {
        val s=obj.toString.split("+")
        if(s(0) == "a" ) { // assumingn it's a non empty string
            println(obj.asInstanceOf[SomeClass].x)
        }

    }
    def main(args:Array[String]):Unit = {
        funct(new SomeClass("a+b"))
    }
}