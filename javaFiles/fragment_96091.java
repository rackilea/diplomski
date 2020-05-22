public static EnumSet< DaysOfWeek > fromBitValues (
        final int origBitMask
    )
{
    final EnumSet< DaysOfWeek > ret_val =
        EnumSet.noneOf( DaysOfWeek.class );

    int bitMask = origBitMask;

    for ( final DaysOfWeek val : DaysOfWeek.values( ) )
    {
        if ( ( val.bitValue & bitMask ) == val.bitValue )
        {
            bitMask &= ~val.bitValue;

            ret_val.add( val );
        }
    }

    if ( bitMask != 0 )
    {
        throw
            new IllegalArgumentException(
                String.format(
                    "Bit mask value 0x%X(%d) has unsupported bits " +
                    "0x%X.  Extracted values: %s",
                    origBitMask,
                    origBitMask,
                    bitMask,
                    ret_val
                )
            );
    }

    return ret_val;
}