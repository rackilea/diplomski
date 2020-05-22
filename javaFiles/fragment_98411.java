String broker = "tcp://iot.eclipse.org:1883";
client = new MqttClient(broker, "javachatclientid1", new MemoryPersistence());
client.setCallback(m_callbackHandler);
MqttConnectOptions connOpts = new MqttConnectOptions();
connOpts.setCleanSession(true);
connOpts.setUserName("username");
connOpts.setPassword("password");
client.connect(connOpts);