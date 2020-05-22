@Configuration
public class RealTimeThreadConfig {

    @Autowired
    private SensorReadingService sensorReadingService;

    @Bean
    public RealTimeThreadFactory realTimeThreadFactory() {
        RealTimeThreadFactory realTimeThreadFactory = new RealTimeThreadFactory(sensorReadingService);
        return realTimeThreadFactory;
    }

}