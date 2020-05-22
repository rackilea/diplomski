public enum RPCPacketDataType
{
    PT_UNKNOWN(2),
    PT_JSON(4),
    PT_BINARY(5);

    RPCPacketDataType (int i)
    {
        this.type = i;
    }

    private int type;

    public int getNumericType()
    {
        return type;
    }
}