import java.nio.charset.StandardCharsets

import com.amazonaws.services.kms.{AWSKMS, AWSKMSClientBuilder}
import com.amazonaws.services.kms.model.DecryptRequest
import java.nio.ByteBuffer
import com.google.common.io.BaseEncoding

object KMSUtils {

  val keyId = "arn:aws:kms:us-east-1:{Account ID}:key/{KEY ID}"

  def decrypt(base64EncodedValue: String): String = {
    val kmsClient: AWSKMS = AWSKMSClientBuilder.standard.build

    val textDecoded: ByteBuffer = ByteBuffer.wrap(BaseEncoding.base64().decode(base64EncodedValue))

    val req : DecryptRequest = new DecryptRequest().withCiphertextBlob(textDecoded)
    val plainText : ByteBuffer = kmsClient.decrypt(req).getPlaintext

    val printable = StandardCharsets.UTF_8.decode(plainText).toString

    return printable
  }

}