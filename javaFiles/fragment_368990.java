Flowable.range(1, number)
.parallel()
.runOn(Schedulers.computation())
.map(BigInteger:valueOf)
.reduce(() -> BigInteger.ONE, BigInteger::multiply)
.reduce(BigInteger::multiply)
.subscribe();