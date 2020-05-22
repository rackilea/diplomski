public static void processIterm(Supplier<Key> s)
    throws SomeCheckedException  {

    attempt( (Function<SomeCheckedException, RuntimeException> thrower) ->
        Optional.ofNullable(s).ifPresent(nonNull -> {
            try { key(nonNull.get()); } // assuming key may throw SomeCheckedException
            catch(SomeCheckedException  e) { throw thrower.apply(e); }
        }));
}