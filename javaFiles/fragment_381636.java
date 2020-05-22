// Create a Xuggler container object
IContainer container = IContainer.make();

// Open up the container
if (container.open("/path/to/video.avi", IContainer.Type.READ, null) < 0)
  throw new IllegalArgumentException("could not open file: " + filename);

// query how many streams the call to open found
int numStreams = container.getNumStreams();

// and iterate through the streams to find the first video stream
int videoStreamId = -1;
IStreamCoder videoCoder = null;
for (int i = 0; i < numStreams; i++) {
  // Find the stream object
  IStream stream = container.getStream(i);
  // Get the pre-configured decoder that can decode this stream;
  IStreamCoder coder = stream.getStreamCoder();

  if (coder.getCodecType() == ICodec.Type.CODEC_TYPE_VIDEO) {
    videoStreamId = i;
    videoCoder = coder;
    break;
  }
}
if (videoStreamId == -1)
  throw new RuntimeException("could not find video stream in container: "
      +filename);

/*
 * Now we have found the video stream in this file. 
 * Let's open up our decoder so it can do work.
 */
if (videoCoder.open() < 0)
  throw new RuntimeException("could not open video decoder for container: "
      + filename);

// here you have what you need
int height = videoCoder.getHeight();
int width = videoCoder.getWidth();