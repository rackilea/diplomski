/**
 * @return Jackson jdk8 module to be registered with every bean of type
 *         {@link ObjectMapper}
 */
@Bean
public Module jdk8JacksonModule() {
    return new Jdk8Module();
}