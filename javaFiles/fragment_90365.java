// The list where we put our received publish messages
            final List<Mqtt5Publish> incomingMessagesClient2 = new LinkedList<>();

            // With the async flavour we can add a consumer for the incoming publish messages
            client2.toAsync().publishes(MqttGlobalPublishFilter.ALL, mqtt5Publish ->
                    incomingMessagesClient2.add(mqtt5Publish));

            client1.publishes(MqttGlobalPublishFilter.ALL);  // creates a "publishes" instance thats used to queue incoming messages

            client2.subscribeWith()  // creates a subscription
                    .topicFilter("test/something1/topic")  // filters to receive messages only on this topic (# = Multilevel wild card, + = single level wild card)
                    .qos(MqttQos.AT_LEAST_ONCE)  // Sets the QoS to 2 (At least once)
                    .send();
            System.out.println("The client2 has subscribed");

            client1.publishWith()  // publishes the message to the subscribed topic
                    .topic("test/something1/topic")   // publishes to the specified topic
                    .qos(MqttQos.AT_LEAST_ONCE)
                    .payload(messagebytesend)  // the contents of the message
                    .send();
            System.out.println("The client1 has published");

            client1.publishWith()  // publishes the message to the subscribed topic
                    .topic("test/something1/topic")   // publishes to the specified topic
                    .qos(MqttQos.AT_LEAST_ONCE)
                    .payload("The second message :P".getBytes())  // the contents of the message
                    .send();
            System.out.println("The client1 has published");
            System.out.println();


            TimeUnit.SECONDS.sleep(5);

            incomingMessagesClient2.forEach(mqtt5Publish -> System.out.println(new String(mqtt5Publish.getPayloadAsBytes())));