@FieldOrder({ "val", "param" })
public class Data extends Structure {
    public byte val;
    public short param;
}

@FieldOrder({ "x", "y", "flag", "length", "data_length", "status", "data" })
public class Frame extends Structure {
    public byte x;
    public byte y;
    public NativeLong flag;
    public short length;
    public short data_length;
    public short status;
    public Data[] data = new Data[10];
}