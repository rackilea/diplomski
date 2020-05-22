// See PDF 32000 specification,
// 8.7.4.5.5 Type 4 Shadings (Free-Form Gouraud-Shaded Triangle Meshes)
PDShadingType4 gouraudShading = new PDShadingType4(new COSStream());
gouraudShading.setShadingType(PDShading.SHADING_TYPE4);
// we use multiple of 8, so that no padding is needed
gouraudShading.setBitsPerFlag(8);
gouraudShading.setBitsPerCoordinate(16);
gouraudShading.setBitsPerComponent(8);
COSArray decodeArray = new COSArray();
// coordinates x y map 16 bits 0..FFFF to 0..FFFF to make your life easy
// so no calculation is needed, but you can only use integer coordinates
// for real numbers, you'll need smaller bounds, e.g. 0xFFFF / 0xA = 0x1999
// would allow 1 point decimal result coordinate.
// See in PDF specification: 8.9.5.2 Decode Arrays
decodeArray.add(COSInteger.ZERO);
decodeArray.add(COSInteger.get(0xFFFF));
decodeArray.add(COSInteger.ZERO);
decodeArray.add(COSInteger.get(0xFFFF));
// colors r g b map 8 bits from 0..FF to 0..1
decodeArray.add(COSInteger.ZERO);
decodeArray.add(COSInteger.ONE);
decodeArray.add(COSInteger.ZERO);
decodeArray.add(COSInteger.ONE);
decodeArray.add(COSInteger.ZERO);
decodeArray.add(COSInteger.ONE);
gouraudShading.setDecodeValues(decodeArray);
gouraudShading.setColorSpace(PDDeviceRGB.INSTANCE);

// Function is not required for type 4 shadings and not really useful, 
// because if a function would be used, each edge "color" of a triangle would be one value, 
// which would then transformed into n color components by the function so it is 
// difficult to get 3 "extremes".

OutputStream os = ((COSStream) gouraudShading.getCOSObject()).createOutputStream();
MemoryCacheImageOutputStream mcos = new MemoryCacheImageOutputStream(os);

// Vertex 1, starts with flag1
// (flags always 0 for vertices of start triangle)
mcos.writeByte(0);
// x1 y1 (left corner)
mcos.writeShort(0);
mcos.writeShort(0);
// r1 g1 b1 (red)
mcos.writeByte(0xFF);
mcos.writeByte(0);
mcos.writeByte(0);

// Vertex 2, starts with flag2
mcos.writeByte(0);
// x2 y2 (top corner)
mcos.writeShort(100);
mcos.writeShort(100);
// r2 g2 b2 (green)
mcos.writeByte(0);
mcos.writeByte(0xFF);
mcos.writeByte(0);

// Vertex 3, starts with flag3
mcos.writeByte(0);
// x3 y3 (right corner)
mcos.writeShort(200);
mcos.writeShort(0);
// r3 g3 b3 (blue)
mcos.writeByte(0);
mcos.writeByte(0);
mcos.writeByte(0xFF);

mcos.close();
// outside stream MUST be closed as well, see javadoc of MemoryCacheImageOutputStream
os.close();