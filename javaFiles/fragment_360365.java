@Test
public void test_on_message() {

    MQTTController controller = new MQTTController();

    MqttMessage message = new MqttMessage();

    controller.messageArrived("my_topic", message);

    ...
}