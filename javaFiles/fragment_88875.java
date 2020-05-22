BigDecimal myDecimalValue = new BigDecimal("99.9999");

//First we need to make sure the BigDecimal matches our schema scale:
myDecimalValue = myDecimalValue.setScale(4, RoundingMode.HALF_UP);

//Next we get the decimal value as one BigInteger (like there was no decimal point)
BigInteger myUnscaledDecimalValue = myDecimalValue.unscaledValue();

//Finally we serialize the integer
byte[] decimalBytes = myUnscaledDecimalValue.toByteArray();

//We need to create an Avro 'Fixed' type and pass the decimal schema once more here:
GenericData.Fixed fixed = new GenericData.Fixed(new Schema.Parser().parse("{\"type\": \"fixed\", \"size\":16, \"precision\": 32, \"scale\": 4, \"name\":\"mydecimaltype1\"}"));

byte[] myDecimalBuffer = new byte[16];
if (myDecimalBuffer.length >= decimalBytes.length) {            
    //Because we set our fixed byte array size as 16 bytes, we need to
    //pad-left our original value's bytes with zeros
    int myDecimalBufferIndex = myDecimalBuffer.length - 1;
    for(int i = decimalBytes.length - 1; i >= 0; i--){
        myDecimalBuffer[myDecimalBufferIndex] = decimalBytes[i];
        myDecimalBufferIndex--;
    }
    //Save result
    fixed.bytes(myDecimalBuffer);
} else {
    throw new IllegalArgumentException(String.format("Decimal size: %d was greater than the allowed max: %d", decimalBytes.length, myDecimalBuffer.length));
}

//We can finally write our decimal to our record
record.put("myDecimal", fixed);