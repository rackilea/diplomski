public boolean matches(CharSequence rawPassword, String encodedPassword) {
    if (encodedPassword == null || encodedPassword.length() == 0) {
        logger.warn("Empty encoded password");
        return false;
    }
    if (!BCRYPT_PATTERN.matcher(encodedPassword).matches()) {
        logger.warn("Encoded password does not look like BCrypt");
        return false;
    }
    return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
}