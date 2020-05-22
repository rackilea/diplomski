@@ -617,10 +617,13 @@
      * looking up the pattern required on demand.
      * <p>
      * The returned formatter has a chronology of ISO set to ensure dates in
      * other calendar systems are correctly converted.
      * It has no override zone and uses the {@link ResolverStyle#SMART SMART} resolver style.
+     * The {@code FULL} and {@code LONG} styles typically require a time-zone.
+     * When formatting using these styles, a {@code ZoneId} must be available,
+     * either by using {@code ZonedDateTime} or {@link DateTimeFormatter#withZone}.
      *
      * @param timeStyle  the formatter style to obtain, not null
      * @return the time formatter, not null
      */
     public static DateTimeFormatter ofLocalizedTime(FormatStyle timeStyle) {