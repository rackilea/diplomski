@Bean
public MeterFilter meterFilter() {
    return new MeterFilter() {
        @Override
        public Meter.Id map(Meter.Id id) {
            if("jvm.memory.used".equals(id.getName())) {
                List<Tag> tags = id.getTags().stream().filter(t -> !"id".equals(t.getKey())).collect(Collectors.toList());
                return id.replaceTags(tags);
            }
           return id;
        }
    };
}