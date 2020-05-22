ZonedDateTime now = ZonedDateTime.ofInstant(Instant.now(),ZoneId.systemDefault()); 

// need longs because setter methods accept either Date or long 
long effectiveTime = now.toInstant().toEpochMilli();
long expireTime = now.plusMinutes(2).toInstant().toEpochMilli();


// send 
order.setEffectiveTime(effectiveTime)
      .setExpireTime(expireTime)
      .send();


// Verify
String expectedEffectiveTime = now.withZoneSameInstant(ZoneId.of("Europe/London"))
                                  .toLocalTime().toString();

String expectedExpireTime = now.withZoneSameInstant(ZoneId.of("Europe/London"))
                               .plusMinutes(2).toLocalTime().toString();


String logString = getLogString(order);
Assert.assertTrue(logString.contains(expectedEffectiveTimeText));
Assert.assertTrue(logString.contains(expectedExpireTimeText));