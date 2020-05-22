public static void checkAndThrow(int val, String name)
    throws ValidationException
{
    if (!isValidValue(val) {
        throw new ValidationException(UserErrors.UE_BAD_PARAMS,
            new Object[] { name, "must be between 0 and 5" });
    }
}