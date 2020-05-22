double convertKgToMass(int destinationUnitType, double kilos)
{
    switch (destinationUnitType)
    {
    case TYPE_KG:
        return kilos;
    case TYPE_POUND:
        return kilos / 0.453592;
    }
}