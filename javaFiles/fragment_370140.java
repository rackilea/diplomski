[StructLayout(LayoutKind.Explicit)]
    public struct FloatToIntConverter
    {
        [FieldOffset(0)]
        public int IntValue;
        [FieldOffset(0)]
        public float FloatValue;
    }

        FloatToIntConverter converter = new FloatToIntConverter();
        converter.FloatValue = value;
        int result2 = converter.IntValue;