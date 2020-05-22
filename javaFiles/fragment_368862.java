public void fixSamsungBug()
{
    DataSource channel = null;
    try
    {
        channel = new FileDataSourceImpl(app.dataMgr.videoFileURL);
    } catch (FileNotFoundException e)
    {
        e.printStackTrace();
    }

    IsoFile isoFile = null;

    try
    {
        isoFile = new IsoFile(channel);
    } catch (IOException e)
    {
        e.printStackTrace();
    }

    List<TrackBox> trackBoxes = isoFile.getMovieBox().getBoxes(TrackBox.class);
    boolean sampleError = false;
    for (TrackBox trackBox : trackBoxes) {
        TimeToSampleBox.Entry firstEntry = trackBox.getMediaBox().getMediaInformationBox().getSampleTableBox().getTimeToSampleBox().getEntries().get(0);

        // Detect if first sample is a problem and fix it in isoFile
        // This is a hack. The audio deltas are 1024 for my files, and video deltas about 3000
        // 10000 seems sufficient since for 30 fps the normal delta is about 3000
        if(firstEntry.getDelta() > 10000) {
            sampleError = true;
            firstEntry.setDelta(3000);
        }
    }

    if(sampleError) {
        Log.d("gpinterviewandroid", "Sample error! correcting...");
        Movie movie = new Movie();
        for (TrackBox trackBox : trackBoxes) {
            movie.addTrack(new Mp4TrackImpl(channel.toString() + "[" + trackBox.getTrackHeaderBox().getTrackId() + "]" , trackBox));
        }
        movie.setMatrix(isoFile.getMovieBox().getMovieHeaderBox().getMatrix());
        Container out = new DefaultMp4Builder().build(movie);

        //delete file first!
        File file = new File(app.dataMgr.videoFileURL);
        boolean deleted = file.delete();


        FileChannel fc = null;
        try
        {
            //fc = new FileOutputStream(new File(app.dataMgr.videoFileURL)).getChannel();
            fc = new RandomAccessFile(app.dataMgr.videoFileURL, "rw").getChannel();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        try
        {
            out.writeContainer(fc);
            fc.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        Log.d("gpinterviewandroid", "Finished correcting raw video");
    }
}