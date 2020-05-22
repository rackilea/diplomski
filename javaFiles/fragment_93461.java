public interface Parser {
    String[] parse(String s);
}

public interface ParserFactory {
    Parser getBySpaceParser();
    Parser getByCommaParser();
}

public class ParserDepot {
    private static ServiceLoader<ParserFactory> loader
            = ServiceLoader.load(ParserFactory.class);

    public static ParserFactory getDefaultParserFactory() {
        final List<ParserFactory> factories = new ArrayList<>();
        loader.forEach(factories::add);
        if (factories.isEmpty()) {
            throw new IllegalStateException("No ParserFactory found");
        }
        return factories.get(0);
    }
}