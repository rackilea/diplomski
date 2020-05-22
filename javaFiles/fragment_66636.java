public void v(final R<?> r) {
    //necessary to placate javac - this is okay because [insert above reasoning]
    @SuppressWarnings("rawtypes")
    N nRaw = r.o;
    p(nRaw);
}