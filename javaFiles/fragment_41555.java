try {
    chain.doFilter(req,resp);
} catch (Exception e) {
    logger.error("", e);
    throw new RuntimeException(e);
}