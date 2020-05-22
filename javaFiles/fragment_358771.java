public void imageToMP4(BufferedImage bi) {
    // A transform to convert RGB to YUV colorspace
    RgbToYuv420 transform = new RgbToYuv420(0, 0);

    // A JCodec native picture that would hold source image in YUV colorspace
    Picture toEncode = Picture.create(bi.getWidth(), bi.getHeight(), ColorSpace.YUV420);

    // Perform conversion
    transform.transform(AWTUtil.fromBufferedImage(bi), yuv);

    // Create MP4 muxer
    MP4Muxer muxer = new MP4Muxer(sink, Brand.MP4);

    // Add a video track
    CompressedTrack outTrack = muxer.addTrackForCompressed(TrackType.VIDEO, 25);

    // Create H.264 encoder
    H264Encoder encoder = new H264Encoder(rc);

    // Allocate a buffer that would hold an encoded frame
    ByteBuffer _out = ByteBuffer.allocate(ine.getWidth() * ine.getHeight() * 6);

    // Allocate storage for SPS/PPS, they need to be stored separately in a special place of MP4 file
    List<ByteBuffer> spsList = new ArrayList<ByteBuffer>();
    List<ByteBuffer> ppsList = new ArrayList<ByteBuffer>();

    // Encode image into H.264 frame, the result is stored in '_out' buffer
    ByteBuffer result = encoder.encodeFrame(_out, toEncode);

    // Based on the frame above form correct MP4 packet
    H264Utils.encodeMOVPacket(result, spsList, ppsList);

    // Add packet to video track
    outTrack.addFrame(new MP4Packet(result, 0, 25, 1, 0, true, null, 0, 0));

    // Push saved SPS/PPS to a special storage in MP4
    outTrack.addSampleEntry(H264Utils.createMOVSampleEntry(spsList, ppsList));

    // Write MP4 header and finalize recording
    muxer.writeHeader();

}