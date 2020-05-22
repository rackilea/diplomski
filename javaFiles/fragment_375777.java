@Component
@ConditionalOnBean({CounterService.class, GaugeService.class})
public class SomeMetrics {

    // Content ommitted for brevity.
}