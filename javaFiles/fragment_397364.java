public boolean canOverride(ResolvedMethod m1, ResolvedMethod m2) {
    if (!m1.getName().equals(m2.getName())) return false;

    int count = m1.getArgumentCount();
    if (count != m2.getArgumentCount()) return false;

    for (int i = 0; i < count; i++) {
        if (!m1.getArgumentType(i).equals(m2.getArgumentType(i))) return false;
    }

    return true;
}