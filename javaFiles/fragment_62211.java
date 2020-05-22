@Override
public void onResponse(Observation observation, Registration registration, ObserveResponse response) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Received notification from [{}] containing value [{}]", observation.getPath(),
                        response.getContent().toString());
            }

            if (registration != null) {
                String data = new StringBuilder("{\"ep\":\"").append(registration.getEndpoint()).append("\",\"res\":\"")
                        .append(observation.getPath().toString()).append("\",\"val\":")
                        .append(gson.toJson(response.getContent())).append("}").toString();

                sendEvent(EVENT_NOTIFICATION, data, registration.getEndpoint());
            }
}