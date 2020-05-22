@Configuration
public class MyConfiguration {
    @Autowired private WhiteColourHandler whiteColourHandler;

    @Bean public Map<ColourEnum, ColourHandler> colourHandlers() {
        Map<ColourEnum, ColourHandler> map = new EnumMap<>();
        map.put(WHITE, whiteColourHandler);
        //put more objects into this map here
        return map;
    }
}