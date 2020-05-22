for (ApnsDevice apnsDevice : apnsDeviceList) {
            try {
                PayloadBuilder perDevicePayloadBuilder = payloadBuilder.copy()
                        .badge(apnsDevice.getBadgeCount()+1);

                // check if the message is too long (it won't be sent if it is)
                //and trim it if it is.
                if (perDevicePayloadBuilder.isTooLong()) {
                    logger.warn("Payload is too long, shrinking it");
                    perDevicePayloadBuilder = perDevicePayloadBuilder.shrinkBody();
                }

                String token = apnsDevice.getDeviceToken();

                service.push(token, perDevicePayloadBuilder.build());

            } catch (Exception ex) {
               logger.error("Error while pushing apns alerts", ex);
            }
        }