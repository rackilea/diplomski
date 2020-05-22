<Resource name="jms/activemq-factory" 
        auth="Container" 
        type="org.apache.activemq.ActiveMQConnectionFactory" 
        description="JMS Connection Factory" 
        factory="org.apache.activemq.jndi.JNDIReferenceFactory" 
        brokerURL="tcp://${broker.host}:${broker.port}" 
        brokerName="LocalActiveMQBroker" 
        useEmbeddedBroker="false"/>

<Resource name="jms/activemq-topic" 
            auth="Container" 
            type="org.apache.activemq.command.ActiveMQTopic" 
            factory="org.apache.activemq.jndi.JNDIReferenceFactory" 
            physicalName="activemq-topic"/>