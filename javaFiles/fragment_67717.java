public static String validate(String name) {
    if (name != null && !name.isEmpty() && (name.charAt(0) == '#' || name.charAt(0) == '-')) {
        return null;
    }
    return name;
}

class User {
    User(String userId, String fname, String lname, String mname) {
        this.userId = validate(userId);
        this.fname = validate(fname);
        this.lname = validate(lname);
        this.mname = validate(mname);
    }