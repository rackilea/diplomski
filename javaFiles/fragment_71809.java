<broker>
    <persistenceAdapter>
        <kahaDB directory="${activemq.data}/kahadb"/>
    </persistenceAdapter>

    ...

    <destinationInterceptors>
        <virtualDestinationInterceptor>
            <virtualDestinations>
                <compositeTopic name="fan-out" forwardOnly="true">
                    <forwardTo>
                        <queue physicalName="persistent"/>
                        <queue physicalName="ephemeral"/>
                    </forwardTo>
                </compositeTopic>
            </virtualDestinations>
        </virtualDestinationInterceptor>
    </destinationInterceptors>
</broker>

<camelContext xmlns="http://camel.apache.org/schema/spring" id="camel">
    <route>
        <from uri="activemq:queue:ephemeral"/>
        <to uri="activemq:queue:ephemeral-backend?timeToLive=10000"/>
    </route>
</camelContext>