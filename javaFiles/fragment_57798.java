addresses: Seq[Address] = {
      import scala.collection.JavaConverters._
      config.getConfigList("amqp.addresses").asScala.map(address ⇒
        Address(
          host = address.foo()
        ))(collection.breakOut)
}