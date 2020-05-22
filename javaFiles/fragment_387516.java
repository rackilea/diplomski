private static final int POLYNOMIAL   = 0x8408;
private static final int PRESET_VALUE = 0xFFFF;

public static int crc16(byte[] data)
{
  int current_crc_value = PRESET_VALUE;
  for (int i = 0; i < data.length; i++ )
  {
    current_crc_value ^= data[i] & 0xFF;
    for (int j = 0; j < 8; j++)
    {
      if ((current_crc_value & 1) != 0)
      {
        current_crc_value = (current_crc_value >>> 1) ^ POLYNOMIAL;
      }
      else
      {
        current_crc_value = current_crc_value >>> 1;
      }
    }
  }
  current_crc_value = ~current_crc_value;

  return current_crc_value & 0xFFFF;
}