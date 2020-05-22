/**
 * A {@code boolean} indicating if the {@link KafkaProducerMessageHandler}
 * should wait for the send operation results or not. Defaults to {@code false}.
 * In {@code sync} mode a downstream send operation exception will be re-thrown.
 * @param sync the send mode; async by default.
 * @since 2.0.1
 */
public void setSync(boolean sync) {