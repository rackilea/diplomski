String msg = "messages";
MqttMessage message = new MqttMessage();
message.setRetained(true);
message.setPayload(msg.getBytes());
try {
    client_Panic.publish(topic, message);
} catch (MqttException e) {
    e.printStackTrace();
}