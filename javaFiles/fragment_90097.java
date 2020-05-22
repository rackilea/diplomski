String value = "2019-02-13 13:35:05";

final long NANOS_PER_HOUR = TimeUnit.HOURS.toNanos(1);
final long NANOS_PER_MINUTE = TimeUnit.MINUTES.toNanos(1);
final long NANOS_PER_SECOND = TimeUnit.SECONDS.toNanos(1);

// Parse date
SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
cal.setTime(parser.parse(value));

// Calculate Julian days and nanoseconds in the day
LocalDate dt = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH));
int julianDays = (int) JulianFields.JULIAN_DAY.getFrom(dt);
long nanos = (cal.get(Calendar.HOUR_OF_DAY) * NANOS_PER_HOUR)
        + (cal.get(Calendar.MINUTE) * NANOS_PER_MINUTE)
        + (cal.get(Calendar.SECOND) * NANOS_PER_SECOND);

// Write INT96 timestamp
byte[] timestampBuffer = new byte[12];
ByteBuffer buf = ByteBuffer.wrap(timestampBuffer);
buf.order(ByteOrder.LITTLE_ENDIAN).putLong(nanos).putInt(julianDays);

// This is the properly encoded INT96 timestamp
Binary tsValue = Binary.fromReusedByteArray(timestampBuffer);