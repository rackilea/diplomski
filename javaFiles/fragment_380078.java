byte[] test = new byte[2];
test[0] = (byte)0x0D;
test[1] = (byte)0x82;

DPTXlator2ByteFloat floatTranslator = new DPTXlator2ByteFloat(DPTXlator2ByteFloat.DPT_AIR_PRESSURE);
floatTranslator.setData(test);
double value = (double)floatTranslator.getValueFloat();