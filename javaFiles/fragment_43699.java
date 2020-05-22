import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;

class MyActorInJava extends AbstractActorWithStash {
  LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
  ...
}