@Override
public String toString()
{
    return super.toString() + // Here
            "\n Years Old:\t"+yearsOld+
            "\n Previous State:\t"+getPreviousLicenseState();
}