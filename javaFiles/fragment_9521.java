/**
 * To be used from services
 * @return
 */
public static Account getCurrentContextAccount() {
    return (Account) AUTH_ACCOUNT_KEY.get();
}

/**
 * To be used from services
 * @return
 */
public static String getCurrentContextSessionToken() {
    return (String) AUTH_TOKEN_KEY.get();
}