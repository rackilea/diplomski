import java.util._
import java.io._
val props = new Properties
props.setProperty("key", "value")
props.store(System.out, "Message")
val task = new TimerTask() {
  def run = {
    props.remove("key")
    props.storeToXML(System.out, "no comment")
  }
}
new Timer().schedule(task, 3000l)
// the properties file is rewritten (to System.out) some 3 seconds later.