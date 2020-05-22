boolean committed = false;
try {
    // Do stuff
    commit(session);
    committed = true;
} catch (HibernateException e) {
    logger.error("delete failed", e);
    throw e;
} finally {
    if (!committed) {
        rollback(session);
    }
    // TODO: This won't execute if rollback fails.
    // Check whether that's a problem.
    close(session);
}