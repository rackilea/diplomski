@Configuration
public class ObjectMapperConfiguration {

    ObjectMapper mapper(@Value("${my.test.string}") String test) {
        ObjectMapper mapper = new ObjectMapper();
        InjectableValues.Std std = new InjectableValues.Std();
        std.addValue("my.test.string", "test");
        mapper.setInjectableValues(std);
        return mapper;
    }
}