/**
 * This method can be used to verify a computed hash from a plaintext (e.g.
 * during a login request) with that of a stored hash from a database. The
 * password hash from the database must be passed as the second argument.
 *
 * @param passwordAsPlainText The accounts plaintext password, as provided
 *                            during a login request
 *
 * @param storedEncryption    The accounts stored password hash, retrieved
 *                            from the authorization database
 *
 * @return boolean - true if the password matches the password of the stored
 *         hash, false otherwise
 */
/*
public static boolean checkPassword(String passwordAsPlainText, String storedEncryption) {
    boolean passwordVerification;

    if (null == storedEncryption || !storedEncryption.startsWith("$2a$")) {
        throw new java.lang.IllegalArgumentException(
                "Invalid encryption provided for comparison");
    }

    passwordVerification = checkpw(passwordAsPlainText, storedEncryption);

    return passwordVerification;
}