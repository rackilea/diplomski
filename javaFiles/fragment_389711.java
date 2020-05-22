// move stuff a bit up
    stream.concatenate2CTM(AffineTransform.getTranslateInstance(100, 400));

    stream.setStrokingColorSpace(PDDeviceRGB.INSTANCE);
    stream.setStrokingColor(Color.red);
    stream.setNonStrokingColorSpace(PDDeviceRGB.INSTANCE);
    stream.setNonStrokingColor(Color.blue);

    stream.setLineWidth(10f);
    stream.moveTo(1, 1);
    stream.addBezier32(111, 075, 200, 200);
    stream.addBezier32(352, 124, 80, 80);
    stream.addBezier32(432, 333, 300, 333);
    stream.addBezier32(234, 129, 200, 300);
    stream.closeSubPath();
    stream.appendRawCommands("\nB*\n"); // Fill and then stroke the path, using the even-odd rule
    // to use the nonzero winding number rule, use "B" instead of "B*"