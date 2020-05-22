static int RotateLeft(int value, int shift)
{
    unchecked
    {
        uint uvalue = (uint) value;
        uint uresult = (uvalue << shift) | (uvalue >> 32 - shift);
        return (int) uresult;
    }
}