/**
     * Encoding data
     * bcrypt is a key derivation function which is used in this instance as a cryptographic hash function
     * @param data
     * @return
     */
    public static String bCrypt(String data) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        return passwordEncoder.encode(data);
    }