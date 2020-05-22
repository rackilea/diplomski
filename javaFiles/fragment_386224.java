public static void test(AssetInfo assetToEncode) throws ServiceException, InterruptedException {

        String preset = new StringBuilder(StringUtils.EMPTY)//
                .append("<Preset xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" Version=\"1.0\" xmlns=\"http://www.windowsazure.com/media/encoding/Preset/2014/03\">")
                .append("<Encoding>")//
//              .append(" <PngImage Start=\"{Best}\">") // get one thumbnail
                 .append(" <PngImage Start=\"5%\" Step=\"10%\" Range=\"96%\">") // get series of thumbnails
                .append("       <PngLayers>")//
                .append("           <PngLayer>")//
                .append("               <Width>100%</Width>")//
                .append("               <Height>100%</Height>")//
                .append("           </PngLayer>")//
                .append("       </PngLayers>")//
                .append("   </PngImage>")//
                .append("</Encoding>")//
                .append("<Outputs>")//
                .append("  <Output FileName=\"{Basename}_{Index}{Extension}\">")//
                .append("       <PngFormat />")//
                .append("   </Output>")//
                .append("</Outputs>")//
                .append("</Preset>")//
                .toString();

        // Retrieve the list of Media Processors that match the name
        ListResult<MediaProcessorInfo> mediaProcessors = mediaService
                .list(MediaProcessor.list().set("$filter", String.format("Name eq '%s'", preferedEncoder)));

        // Use the latest version of the Media Processor
        MediaProcessorInfo mediaProcessor = null;
        for (MediaProcessorInfo info : mediaProcessors) {
            if (null == mediaProcessor || info.getVersion().compareTo(mediaProcessor.getVersion()) > 0) {
                mediaProcessor = info;
            }
        }

        System.out.println("Using Media Processor: " + mediaProcessor.getName() + " " + mediaProcessor.getVersion());


        // Create a task with the specified Media Processor
        String outputAssetName = String.format("%s as %s", assetToEncode.getName(), preset);

        String taskXml = new StringBuilder(StringUtils.EMPTY)//
                .append("<taskBody>")//
                .append(" <inputAsset>JobInputAsset(0)</inputAsset>")//
                .append(" <outputAsset assetCreationOptions=\"0\" assetName=\"" + outputAssetName
                        + "\">JobOutputAsset(0)</outputAsset>")//
                .append("</taskBody>").toString();//


        Task.CreateBatchOperation task = Task.create(mediaProcessor.getId(), taskXml).setConfiguration(preset)
                .setName("Thumbnails");

        // Create the Job; this automatically schedules and runs it.
        Job.Creator jobCreator = Job.create()
                .setName(String.format("Encoding %s to %s", assetToEncode.getName(), preset))
                .addInputMediaAsset(assetToEncode.getId()).setPriority(2).addTaskCreator(task);
        JobInfo job = mediaService.create(jobCreator);

        String jobId = job.getId();
        System.out.println("Created Job with Id: " + jobId);

        // Check to see if the Job has completed
        checkJobStatus(jobId);
    }