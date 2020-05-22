@Bean
public MeterFilter meterFilter() {
    return MeterFilter.deny(
        id -> "jvm.memory.used".equals(id.getName()) &&
              id.getTags().stream().anyMatch(t -> "id".equals(t.getKey()))
         );
    }