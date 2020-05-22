public static MyEnum enumToEnum(final Enum<? extends Enum<?>> externalEnum)
{
    try
    {
        return MyEnum.valueOf(externalEnum.name());
    }
    catch (Exception ex)
    {
        return MyEnum.UNKNOWN;
    }
}