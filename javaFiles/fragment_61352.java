@Aspect
class EventProcessor  {

  @Before("execution(* com.mypackage.*.application.commands.*.*(..))")
  def listen() {
    DomainEventPublisher.instance().subscribe(new DomainEventSubscriber[Event] {

      def handleEvent(domainEvent: Event) {
        val eventRepository = SpringContext.ctx.getBean("eventRepository", classOf[EventRepository])
        eventRepository.save(domainEvent)
      }

      def subscribedToEventType = {
        classOf[Event]
      }
    })
  }

}