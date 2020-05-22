try {
    em.persist(entity);
} catch (RuntimeException e) {
    if (e.getCause() instanceof BusinessException) {
        // Fix the problem the way you want
    } else {
        throw e;
    }
}