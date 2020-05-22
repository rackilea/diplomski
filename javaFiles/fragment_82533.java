@Configuration
public class MyConfiguration {
    @Bean public Map<ColourEnum, ColourHandler> colourHandlers() {
        Map<ColourEnum, ColourHandler> map = new EnumMap<>();
        map.put(WHITE, whiteHandler());
        // etc
        return map;
    }

    @Bean public ColourHandler whiteHandler() {
        return new WhiteHandler();
    }
}