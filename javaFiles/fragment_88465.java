while (in.isReadable()) {
    int outputSizeBefore = out.size();
    int readableBytesBefore = in.readableBytes();

    callYourDecodeImpl(ctx, in, out);

    int outputSizeAfter = out.size();
    int readableBytesAfter = in.readableBytes();

    boolean didNotDecodeAnything = outputSizeBefore == outputSizeAfter;
    boolean didNotReadAnything = readableBytesBefore == readableBytesAfter;

    if(didNotDecodeAnything && didNotReadAnything) {
        break;
    }

    // next iteration, continue with decoding
}