public class MapperUtils {

    public static OffsetDateTime fromInstant(Instant instant) {
        return instant == null ? null : instant.atOffset(ZoneOffset.UTC);
    }
}