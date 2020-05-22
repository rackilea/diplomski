protected String mergePasswordAndSalt(String password, Object salt, boolean strict) {
    if (password == null) {                                                              /* 1 */
        password = "";
    }

    if (strict && (salt != null)) {                                                      /* 2 */
        if ((salt.toString().lastIndexOf("{") != -1)
                || (salt.toString().lastIndexOf("}") != -1)) {
            throw new IllegalArgumentException("Cannot use { or } in salt.toString()");
        }
    }

    if ((salt == null) || "".equals(salt)) {
        return password;
    } else {
        return password + "{" + salt.toString() + "}";                                   /* 3 */
    }
}