@Bean
@Conditional(MyCondition.class)
public ObservationWebSocketClient observationWebSocketClient(){
    log.info("creating web socket connection...");
    return new ObservationWebSocketClient();
}