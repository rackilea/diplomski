Vector<InputStream> inputStreams = new Vector<InputStream>();
inputStreams.add(clip1);
inputStreams.add(clip2);
inputStreams.add(clip3);
// etc...

// add up the lengths
int length = 0;
for (int i = 0 ; i < inputStreams.size(); ++i)
    length += inputStreams.get(i).getFrameLength();

AudioInputStream appendedFiles =
    new AudioInputStream(
            new SequenceInputStream(inputStreams.elements()),
            clip1.getFormat(), length);