import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
...

//We'll use a Random Number Generator to generate salts.  This
//is much more secure than using a username as a salt or not
//having a salt at all.  Shiro makes this easy.
//
//Note that a normal app would reference an attribute rather
//than create a new RNG every time:
RandomNumberGenerator rng = new SecureRandomNumberGenerator();
Object salt = rng.nextBytes();

//Now hash the plain-text password with the random salt and multiple
//iterations and then Base64-encode the value (requires less space than Hex):
String hashedPasswordBase64 = new Sha256Hash(plainTextPassword, salt, 1024).toBase64();

User user = new User(username, hashedPasswordBase64);
//save the salt with the new account.  The HashedCredentialsMatcher
//will need it later when handling login attempts:
user.setPasswordSalt(salt);
userDAO.create(user);