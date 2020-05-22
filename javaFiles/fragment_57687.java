@Singleton
@Transactional(value = TxType.REQUIRED, dontRollbackOn = SomeException.class)
@SomeOtherAnnotations
@Stereotype
@Target(TYPE)
@Retention(RUNTIME)
public @interface MyService {}