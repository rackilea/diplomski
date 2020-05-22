@Bean
public MeterFilter meterFilter() {
    return new MeterFilter() {
        @Override
        public Meter.Id map(Meter.Id id) {
            if("jvm.memory.used".equals(id.getName())) {
                return new Meter.Id(id.getName(), <put tags here>, id.getBaseUnit(), id.getDescription(), id.getType()
            }
           return id;
        }
    };
}