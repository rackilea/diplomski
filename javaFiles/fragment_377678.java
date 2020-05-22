@Caching(evict = {
    @CacheEvict(value = CACHE_BY_ID, key = "#user.userID"),
    @CacheEvict(value = CACHE_BY_LOGIN_NAME, key = "#user.loginName")
    // etc.
})
public T delete(AppID appID, User user) throws UserNotFoundException {
...
}