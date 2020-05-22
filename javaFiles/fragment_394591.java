import org.apache.nifi.processor.ProcessContext
import java.util.concurrent.atomic.AtomicLong

class Const{
  static Date startTime = null;
  static AtomicLong triggerCount = null;
}

static onStart(ProcessContext context){
  Const.startTime = new Date()
  Const.triggerCount = new AtomicLong(0)
  println "onStart $context ${Const.startTime}"
}

static onStop(ProcessContext context){
  def alive = (System.currentTimeMillis() - Const.startTime.getTime()) / 1000
  println "onStop $context executed ${ Const.triggerCount } times during ${ alive } seconds"
}

def flowFile = session.get()
if(!flowFile)return
flowFile.'trigger.count' = Const.triggerCount.incrementAndGet()
REL_SUCCESS << flowFile