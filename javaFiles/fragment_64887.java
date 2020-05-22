IMediaWriter writer = ToolFactory.makeWriter("output.ts");
writer.addVideoStream(0, 0, ICodec.ID.CODEC_ID_H264, width, height);
for (...)
{

   BufferedImage mjpeg = ...;

   writer.encodeVideo(0, mjpeg);
}