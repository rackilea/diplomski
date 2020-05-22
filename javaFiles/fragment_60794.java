scala> import sys.process._
import sys.process._

scala> def processExists(pid: Int) = pid == {try { (List("ps", "-p", s"$pid", "-o", "pid=") !!).trim.toInt } catch { case _: Throwable => -1 }}
warning: there was one feature warning; re-run with -feature for details
processExists: (pid: Int)Boolean

scala> val pid = 8238
pid: Int = 8238

scala> processExists(pid)
res11: Boolean = true

scala> processExists(1234)
res12: Boolean = false