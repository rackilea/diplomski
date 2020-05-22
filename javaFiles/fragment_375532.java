<camelContext xmlns="http://camel.apache.org/schema/spring">
    <route>
        <from uri="mqtt:apsssub?host=tcp://10.30.11.0:1883&amp;subscribeTopicName=apss/messages" />
            <unmarshal ref="gson" />
            <bean beanType="com.hk.MessageHeaderSetter" method="putMessageTypeInHeader" />
            <choice>
                <when>
                    <simple>${headers.msg_type} == 'location_update'</simple>
                    <log message="Message type 1." />
                    <to uri="jms:LOCATION_UPDATE_QUEUE" />method="updateLocation" />
                </when>
                <otherwise>
                    <log message="Other message" />
                    <log message="Headers ${headers}" />
                    <to uri="stream:out" />
                </otherwise>
            </choice>
    </route>
</camelContext>