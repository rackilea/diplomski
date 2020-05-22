MediaLocator ml=new MediaLocator("screen://0,0,1280,800/25");

DataSource clone=null;

try {
        ds = new DataSourcePantalla();
        ds.setLocator(ml);
        clone = javax.media.Manager.createCloneableDataSource(ds);
} catch (Exception e) {
        System.out.println(e.getMessage());
}

try {
        ds.connect();
        clone.connect();
} catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
}
Format[] outputFormat=new Format[1];
FileTypeDescriptor outputType = new FileTypeDescriptor(FileTypeDescriptor.RAW_RTP);
outputFormat[0]=new VideoFormat(VideoFormat.JPEG_RTP);
ProcessorModel processorModel = new ProcessorModel(clone, outputFormat, outputType);

// Try to create a processor to handle the input media locator
try {
        processor = Manager.createRealizedProcessor(processorModel);
} catch (NoProcessorException npe) {
        System.out.println(npe.getMessage());
} catch (IOException ioe) {
        System.out.println(ioe.getMessage());
} 
catch (CannotRealizeException e) {
        // TODO Auto-generated catch block
        System.out.println(e.getMessage());
}

boolean result = waitForState(processor, Processor.Configured);
if (result == false){
        System.out.println("Error, No se pudo configurar el processor en UnicastRtpPantalla::createMyProcessor");
        return false;
}

TrackControl[] tracks = processor.getTrackControls();
// Search through the tracks for a video track
for (int i = 0; i < tracks.length; i++) {
        Format format = tracks[i].getFormat();
        if (tracks[i].isEnabled() && format instanceof VideoFormat) {
System.out.println("Pista "+i+" de video tiene formato: "+tracks[i].getFormat());
// Found a video track. Try to program it to output JPEG/RTP
// Make sure the sizes are multiple of 8's.
float frameRate = 25;//((VideoFormat) format).getFrameRate();
Dimension size = new Dimension(1280, 800);//((VideoFormat) format).getSize();
int w = (size.width % 8 == 0 ? size.width: (int) (size.width / 8) * 8);
int h = (size.height % 8 == 0 ? size.height: (int) (size.height / 8) * 8);
VideoFormat jpegFormat = new VideoFormat(VideoFormat.JPEG_RTP,
new Dimension(w, h), Format.NOT_SPECIFIED,
Format.byteArray, frameRate);
tracks[i].setFormat(jpegFormat);
System.out.println("Pista "+i+" de video se cambió a formato: "+tracks[i].getFormat());
        } else
tracks[i].setEnabled(false);
}
//              // Set the output content descriptor to RAW_RTP
ContentDescriptor cd = new ContentDescriptor(ContentDescriptor.RAW_RTP);
processor.setContentDescriptor(cd);

ds = processor.getDataOutput();