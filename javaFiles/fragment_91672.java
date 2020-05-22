double convertMassToKg(int sourceUnitType, double source)
{
    switch (sourceUnitType)
    {
    case TYPE_KG:
        return source;
    case TYPE_POUND:
        return source * 0.453592;
    }
}