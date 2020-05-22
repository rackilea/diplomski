Calendar uuidEpoch = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
uuidEpoch.clear();
uuidEpoch.set(1582, 9, 15, 0, 0, 0); // 9 = October
long epochMillis = uuidEpoch.getTime().getTime();

long time = (uuid.timestamp() / 10000L) + epochMillis;
// Rest of code as before