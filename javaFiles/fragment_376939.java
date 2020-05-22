/**
 * Implement this interface in order to be notified of Confirm events.
 * Acks represent messages handled successfully; Nacks represent
 * messages lost by the broker.  Note, the lost messages could still
 * have been delivered to consumers, but the broker cannot guarantee
 * this.
 * For a lambda-oriented syntax, use {@link ConfirmCallback}.
 */
public interface ConfirmListener {
    void handleAck(long deliveryTag, boolean multiple)
        throws IOException;

    void handleNack(long deliveryTag, boolean multiple)
        throws IOException;
}