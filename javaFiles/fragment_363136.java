@Override public boolean equals(final Object obj)
{
    if(obj == this) return true;
    if(obj == null) return false;

    if (getClass ().equals (obj.getClass ()))
    {
        final ImageEntity otherImage = (ImageEntity) obj;

        return Object.equals (getFilePath(), otherImage.getFilePath());
    }

    return false;
}