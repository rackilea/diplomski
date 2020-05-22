MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);

hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
hintMap.put(EncodeHintType.MARGIN, 1); /* default = 4 */
hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

BitMatrix bitMatrix = multiFormatWriter.encode(text2QR, BarcodeFormat.QR_CODE, 500, 500, hintMap);
BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
bitmap = barcodeEncoder.createBitmap(bitMatrix);
imageView = (ImageView) findViewById(R.id.imageView);
imageView.setImageBitmap(bitmap);