@Component
public class MigratingPasswordEncoder implements PasswordEncoder {

    @Autowired
    private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder; // new encoder (BCrypt)

    @Autowired
    private Md5PasswordEncoder legacyEncoder;

    @Autowired
    private UserDao userDao; // where password hashes are stored

    public String encodePassword(String rawPass, Object salt) {
        return passwordEncoder.encode(rawPass);
    }

    public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
        if (legacyEncoder.isPasswordValid(encPass, rawPass, salt)) {
            // MD5 hash found here, save a new hash instead
            userDao.updatePassword(encPass, passwordEncoder.encode(rawPass));
            return true;
        }
        return passwordEncoder.matches(rawPass, encPass);
    }
}