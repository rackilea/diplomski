public class TicketPoller extends RouteBuilder {

/** The uri. */
private final String uri = "jpa://Ticket?consumeDelete=false&consumeLockEntity=true&consumer.SkipLockedEntity=true&consumer.query=select t from Ticket t where t.state=1";

@Override
public void configure() {
    from(uri).delay(10000).to("log:input"); //wait 10sec 

}