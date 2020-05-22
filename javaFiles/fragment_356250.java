object HelloWorld {
   def main(args: Array[String]) = {

        send(true, () => "Foo")

        def send(enabled: Boolean, supplier: () => String) =
            if (enabled) somethingSend(supplier())

        def somethingSend(message: String) = println(message)
   }
}