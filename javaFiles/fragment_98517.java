<channel-definition id="my-amf" class="mx.messaging.channels.AMFChannel">
        <endpoint url="http://{server.name}:{server.port}/{context.root}/messagebroker/amf" class="ch.hedgesphere.core.blazeds.endpoint.AMFEndpoint"/>

         <properties>
            <serialization>
                <type-marshaller>ch.hedgesphere.core.blazeds.translator.HedgesphereASTranslator</type-marshaller>
            </serialization>
        </properties>

    </channel-definition>