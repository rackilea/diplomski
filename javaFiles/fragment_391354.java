import java.util.{HashMap => JHashMap, Map => JMap}

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import scala.beans.BeanProperty
import scala.collection.JavaConversions._
@Component
@ConfigurationProperties(prefix = "security-util")
class SecurityUtilProperties {

  @BeanProperty
  val corporationSecrets: JMap[String, String] = new JHashMap[String, String]

  def corporationSecretsScala = corporationSecrets.asScala
}