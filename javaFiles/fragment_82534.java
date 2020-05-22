@Configuration
public class MyConfiguration {
    @Autowired private WhiteColourHandler whiteColourHandler;

    @Bean public Map<ColourEnum, ColourHandler> colourHandlers() {
        Map<ColourEnum, ColourHandler> map = new EnumMap<>();
        map.put(WHITE, whiteColourHandler);
        return map;
    }
}