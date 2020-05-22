@Test
public void test() {
    Observable.error(new IOException())
    .onErrorResumeNext((Throwable e) -> Observable.error(new IllegalArgumentException()))
    .test()
    .assertFailure(IllegalArgumentException.class);
}