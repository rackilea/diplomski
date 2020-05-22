public static boolean and(Collection<Boolean> booleans)
{
    return !booleans.contains(Boolean.FALSE);
}

public static boolean or(Collection<Boolean> booleans)
{
    return booleans.contains(Boolean.TRUE);
}