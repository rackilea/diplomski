private void MakeThumbnail(MediaContract mediaService, String size, String time) throws ServiceException, InterruptedException, MalformedURLException {

        // Use the Azure Media Encoder, by specifying it by name.
        ListResult<MediaProcessorInfo> mediaProcessors = mediaService
                .list(MediaProcessor.list().set("$filter", "Name eq 'Azure Media Encoder'"));

        // Use the latest version of the media processor.
        MediaProcessorInfo mediaProcessor = null;
        for (MediaProcessorInfo info : mediaProcessors) {
            if (null == mediaProcessor || info.getVersion().compareTo(mediaProcessor.getVersion()) > 0) {
                mediaProcessor = info;
            }
        }

        // Create the Thumbnail task
        String xmlThumbnail = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" + 
           "<Thumbnail Size=\"" + size + "\" Type=\"Jpeg\" " + 
           "Filename=\"{OriginalFilename}_{Size}_{ThumbnailTime}_{ThumbnailIndex}_{Date}_{Time}.{DefaultExtension}\">" + 
           "<Time Value=\"" + time + "\"/></Thumbnail>";

        Task.CreateBatchOperation task = Task
                .create(mediaProcessor.getId(), 
                        "<taskBody><inputAsset>JobInputAsset(0)</inputAsset><outputAsset>JobOutputAsset(0)</outputAsset></taskBody>")
                .setConfiguration(xmlThumbnail)
                .setName("MakeThumbnailTask");

        // Create a job creator that specifies the asset, priority and task for the job.
        Job.Creator jobCreator = Job.create().setName("MakeThumbnailTask").addInputMediaAsset("nb:cid:UUID:ec25435d-1500-80c3-dd89-f1e528b02207").setPriority(2)
                .addTaskCreator(task);

        JobInfo jobInfo = mediaService.create(jobCreator);
        String jobId = jobInfo.getId();

        // Check to see if the job has completed.
        CheckJobStatus(jobId);
        // Done with the job.

        // Retrieve the output asset.
        ListResult<AssetInfo> outputAssets = mediaService.list(Asset.list(jobInfo.getOutputAssetsLink()));
        AssetInfo thumbnailAsset = outputAssets.get(0);

        AccessPolicyInfo downloadAccessPolicy = null;
        double t100years = 100.0 * 365.0 * 24.0 * 60.0;
        downloadAccessPolicy = mediaService
                .create(AccessPolicy.create("Public Thumbnail Policy", t100years, EnumSet.of(AccessPolicyPermission.READ)));

        LocatorInfo downloadLocator = null;
        downloadLocator = mediaService
                .create(Locator.create(downloadAccessPolicy.getId(), thumbnailAsset.getId(), LocatorType.SAS));

        // Lookup the output asset file
        ListResult<AssetFileInfo> assetFiles = mediaService.list(AssetFile.list(thumbnailAsset.getAssetFilesLink()));
        AssetFileInfo jpegFile = null;
        for (AssetFileInfo outputAssetFile : assetFiles) {
            // check if primary output.
            if (outputAssetFile.getIsPrimary())  {
                jpegFile = outputAssetFile;
            }
        }

        // Adding the file name to the URL
        String imageUrl = downloadLocator.getPath().replaceAll("\\?", "/" + jpegFile.getName() + "?");

        System.out.println("Created Thumbnail JPEG URL: " + imageUrl);

 }