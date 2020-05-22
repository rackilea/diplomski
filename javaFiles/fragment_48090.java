public class Parser {

    private final Collection<BaseClass> implementations;

    public Parser(Collection<BaseClass> implementations) {
         this.implementations = implementations;
    }

    public BaseClass parseNew(String value) {
         for (BaseClass implementation : implementations) {
             if (implementation.regex().equals(value)) {
                 return implementation.convert(value);
             }
         }

         throw new IllegalArgumentException("unsupported value");
    }
}