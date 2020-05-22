class Wallet {
  private var publicKey: Option[PublicKey] = None
  private var privateKey: Option[PrivateKey] = None
  private var balance: Int = 0

  def generateKeys(): Unit = {
    val keyPair =  KeyPairGenerator.getInstance("SHA-256").generateKeyPair()
    privateKey = Some(keyPair.getPrivate)
    publicKey = Some(keyPair.getPublic)
  }

  def getBalance = balance
}