@Retryable(value = {Exception.class}, maxAttempts = 5, backoff = @Backoff(delay = 10000))
public void update(Integer id) {
    execute(id);
}

@Recover
public void recover(Exception ex, Integer id){
    logger.error("Error when updating object with id {}", id);
}