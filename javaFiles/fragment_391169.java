import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class MyActor extends AbstractActor {
  private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

  @Inject
  private DoerService doerService;

  @Override
  public Receive createReceive() {
    return receiveBuilder()
      .match(String.class, s -> {
        log.info("Received String message: {}", s);
         doerService.doSomethingNow();
      })
      .matchAny(o -> log.info("received unknown message"))
      .build();
  }