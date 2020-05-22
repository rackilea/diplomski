@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Transactional(value = "transactionManager2", readOnly = true)
public @interface ReadOnlyTransactionManager2Tx {
}

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Transactional(value = "transactionManager2", readOnly = false)
public @interface NonReadOnlyTransactionManager2Tx {
}