String message = "{\"apn\": { \n" +
                    "    \"default\": \"HERE IS AN ALERT, BADGE, and SOUND\",\n" +
                    "    \"APNS_SANDBOX\": \"{\\\"aps\\\": {\\\"alert\\\":\\\"HERE IS AN ALERT, BADGE, and SOUND!\\\",\\\"badge\\\": 1,\\\"sound\\\":\\\"bingbong.aiff\\\"}}\"\n" +
                    "}}";
            publishRequest.setMessage(message);
            publishRequest.setMessageStructure("json");