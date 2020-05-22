package ch.hedgesphere.core.blazeds.endpoint;

import ch.hedgesphere.core.blazeds.serialization.Serializer;

    public class AMFEndpoint extends flex.messaging.endpoints.AMFEndpoint {

    @Override
    protected String getSerializerClassName() {
        return Serializer.class.getName();
        }

    }