trait Credential
trait Client[C] {
  def credential: C
  def getUserProfile(name: String, credential: C): Any
}


object Foo extends App {
  val foundClient: Client[_ <: Credential] = ???

  def getUserProfile[A](client: Client[A], name: String): Any = {
    val credential = client.credential
    client.getUserProfile(name, credential)
  }

  getUserProfile(foundClient, "Foo")
}