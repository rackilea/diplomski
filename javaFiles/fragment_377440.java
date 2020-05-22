@Retention(RUNTIME)
@Target({ FIELD })
@Autowired
public @interface ConfigurationValue {
  String name();

  String defaultValue();
}