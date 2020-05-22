public class JacksonGetter {
    static class TimestampedCount {
        private final Date timestamp;
        private final Map<Long, Integer> counts;

        public TimestampedCount(final Date timestamp, final Map<Long, Integer> counts) {
            this.timestamp = timestamp;
            this.counts = counts;
        }

        public Date getTimestamp() { return timestamp; }

        @JsonProperty("counts")
        public byte[] getCountsAsBytes() {
            return counts.toString().getBytes();
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        final TimestampedCount timestampedCount = new TimestampedCount(
                new Date(),
                Collections.singletonMap(1L, 123));
        final ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(timestampedCount));

    }
}