public void debug(String msg) {
    appendContext();
    logger.debug(msg);
    if(!ThreadContext.isEmpty()){
        ThreadContext.pop();
    }
}