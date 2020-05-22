COSArray decodeArray = new COSArray();
// coordinates x y map 16 bits 0..FFFF to -16384..16384
// this means that 0x8000 maps to 0
// some other useful values
//  - 0x862C maps to top of A4 page
//  - 0x84C4 maps to right of A4 page
//  - 0x8262 maps to horizontal middle of A4 page
decodeArray.add(COSInteger.get(-16384));
decodeArray.add(COSInteger.get(16384));
decodeArray.add(COSInteger.get(-16384));
decodeArray.add(COSInteger.get(16384));
// colors r g b map 8 bits from 0..FF to 0..1
decodeArray.add(COSInteger.ZERO);
decodeArray.add(COSInteger.ONE);
decodeArray.add(COSInteger.ZERO);
decodeArray.add(COSInteger.ONE);
decodeArray.add(COSInteger.ZERO);
decodeArray.add(COSInteger.ONE);
gouraudShading.setDecodeValues(decodeArray);