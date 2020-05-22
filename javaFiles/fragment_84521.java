try {
    connection.setAutoCommit(false);
    connection.setReadOnly(true);
    return pjp.proceed();
} catch (Throwable e) {
    return e;
} finally {
    // restore state
    connection.commit(); // THIS LINE
    connection.setReadOnly(readOnly);
    connection.setAutoCommit(autoCommit);
}