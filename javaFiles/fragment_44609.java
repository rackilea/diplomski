@Retention(RetentionPolicy.RUNTIME)
@Import(TestClockRegistrar.class)
public @interface TestClock {

    String value();

}