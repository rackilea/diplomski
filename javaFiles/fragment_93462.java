public class SoByCommaParser implements Parser {
    @Override
    public String[] parse(String s) {
        return s.split("\\s+,\\s+");
    }
}

public class SoBySpaceParser implements Parser {
    @Override
    public String[] parse(String s) {
        return s.split("\\s+");
    }
}

public class SoParserFactory implements ParserFactory {
    @Override
    public Parser getBySpaceParser() {
        return new SoBySpaceParser();
    }

    @Override
    public Parser getByCommaParser() {
        return new SoByCommaParser();
    }
}