public static <O, T extends O> boolean isMember(O obj, T mate, T... mates) {
    if (obj == null) {
        return false;
    }
    if (obj.equals(mate)) {
        return true;
    }
    for (T m : mates) {
        if (obj.equals(m)) {
            return true;
        }
    }
    return false;
}