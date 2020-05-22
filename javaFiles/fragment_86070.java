MulticastMessage multiCast = MulticastMessage.builder()
                        .putAllData(new HashMap<String, String>() { put("message":"hi"); })
                        .setApnsConfig(ApnsConfig.builder().build())
                        .setAndroidConfig(AndroidConfig.builder().build())
                        .addAllTokens(Arrays.asList("devicetoken1", "devicetoken2"))
                        .build();