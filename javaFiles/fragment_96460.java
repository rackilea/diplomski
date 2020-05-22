/**
     * Maps this promise to a promise of type <code>B</code>.  The function <code>function</code> is applied as
     * soon as the promise is redeemed.
     *
     * Exceptions thrown by <code>function</code> will be wrapped in {@link java.lang.RuntimeException}, unless
     * they are <code>RuntimeException</code>'s themselves.
     *
     * @param function The function to map <code>A</code> to <code>B</code>.
     * @return A wrapped promise that maps the type from <code>A</code> to <code>B</code>.
     */
    public <B> Promise<B> map(final Function<A, B> function) {
        return new Promise<B>(
            promise.map(new scala.runtime.AbstractFunction1<A,B>() {
                public B apply(A a) {
                    try {
                        return function.apply(a);
                    } catch (RuntimeException e) {
                        throw e;
                    } catch(Throwable t) {
                        throw new RuntimeException(t);
                    }
                }
            })
        );
    }