import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public class Sample
{
    public static void main(String... arg)
    {        
        String path = "somewhere";

        Stream<Converter> stream = Stream.of(0, 15, 25, 30).map(
            new Function<Integer, Converter>()
            {
                int previous;
                boolean even = true;

                @Override
                public Converter apply(Integer current)
                {
                    Converter converter = even ? null : new Converter(path, previous, current);

                    even = !even;

                    previous = current;

                    return converter;
                }
            }).filter(Objects::nonNull);

        stream.forEach(System.out::println);
    }

    static class Converter
    {
        private final String path;
        private final int start;
        private final int end;

        Converter(String path, int start, int end)
        {

            this.path = path;
            this.start = start;
            this.end = end;
        }

        public String toString()
        {
            return String.format("Converter[%s,%s,%s]", path, start, end);
        }
    }
}