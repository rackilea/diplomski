Message message = Message.builder()
                .putData("title", NotifType.NEW_USER_ALERT.getTitle())
                .putData("body", "\"" + mzName + "\" contient " + nbrAlertes + " alertes.")
                .putData("tag", mzName)
                .putData("nbrAlerts", nbrAlertes+"")
                .setToken(token)
                .setAndroidConfig(AndroidConfig.builder()
                        .setTtl(30*3600*1000) // 30 hours
                        .build())
                .build();