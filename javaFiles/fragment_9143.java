interface ParserFunction<A> {
    <R> R with(Parser<A, R> a);
}

public static <A> ParserFunction<A> getResult(final A res){
        return new ParserFunction<A>() {
            public <R> R with(Parser<A, R> parser) {
                return parser.parse(res);
            }
        };
}