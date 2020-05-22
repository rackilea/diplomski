/**
 * This method can be used to generate a string representing an account
 * password suitable for storing in a database. It will be an OpenBSD-style
 * crypt(3) formatted hash string of length=60 The BCrypt WORKLOAD is
 * specified in the above static variable, a value from 10 to 31. A WORKLOAD
 * of 12 is a very reasonably safe default. This automatically handles
 * secure 128-bit salt generation and storage within the hash.
 *
 * @param password_plaintext The account's plaintext password as provided
 *                           during account creation, or when changing an
 *                           account's password.
 *
 * @return String - a string of length 60 that is the bcrypt hashed password
 *         in crypt(3) format.
 */
public static String hashPassword(String password_plaintext) {
    String salt = BCrypt.gensalt(WORKLOAD);
    String hashedPassword = hashpw(password_plaintext, salt);
    return hashedPassword;
}