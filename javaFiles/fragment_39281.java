private static ProviderCredentials credentials;
private static S3Service s3service;
private static ThreadedS3Service storageService;
private static S3Bucket bucket;
private List<S3Object> s3Objs=new ArrayList<S3Object>();
private Set<String> s3ObjsCompleted=new HashSet<String>();
private boolean isErrorOccured=true;
private final ByteFormatter byteFormatter = new ByteFormatter();
private final TimeFormatter timeFormatter = new TimeFormatter();


    private void initialise() throws ServiceException, S3ServiceException {
    credentials=<create your credentials>;
        s3service = new RestS3Service(credentials);
        bucket = new S3Bucket(<bucket details>);
        storageService=new ThreadedS3Service(s3service, this);
    }
}

private void uploadFolder(File folder) throws NoSuchAlgorithmException, IOException {
    readFolderContents(folder);
    uploadFilesInList(folder);
}
private void readFolderContents(File folder) throws NoSuchAlgorithmException, IOException {
    Iterator<File> filesinFolder=FileUtils.iterateFiles(folder,null,null);

    while(filesinFolder.hasNext()) {
        File file=filesinFolder.next();
        String key = <create your key from the filename or something>;
        S3Object s3Obj=new S3Object(bucket, file);
        s3Obj.setKey(key);
        s3Obj.setContentType(Mimetypes.getInstance().getMimetype(s3Obj.getKey()));
        s3Objs.add(s3Obj);  
    }
}
private void uploadFilesInList(File folder) {
    logger.debug("Uploading files in folder "+folder.getAbsolutePath());
    isErrorOccured=false;
    s3ObjsCompleted.clear();

    storageService.putObjects(bucket.getName(), s3Objs.toArray(new S3Object[s3Objs.size()]));   

    if(isErrorOccured || s3Objs.size()!=s3ObjsCompleted.size()) {
        logger.debug("Have to try uploading a few objects again for folder "+folder.getAbsolutePath()+" - Completed = "+s3ObjsCompleted.size()+" and Total ="+s3Objs.size());
        List<S3Object> s3ObjsRemaining=new ArrayList<S3Object>();
        for(S3Object s3Obj : s3Objs) {
            if(!s3ObjsCompleted.contains(s3Obj.getKey())) {
                s3ObjsRemaining.add(s3Obj);
            }
        }
        s3Objs=s3ObjsRemaining;
        uploadFilesInList(folder);
    }
}

@Override
public void event(CreateObjectsEvent event) {
    super.event(event);
    if (ServiceEvent.EVENT_IGNORED_ERRORS == event.getEventCode()) {
        Throwable[] throwables = event.getIgnoredErrors();
        for (int i = 0; i < throwables.length; i++) {
            logger.error("Ignoring error: " + throwables[i].getMessage());
        }
    }else if(ServiceEvent.EVENT_STARTED == event.getEventCode()) {
        logger.debug("**********************************Upload Event Started***********************************");
    }else if(event.getEventCode()==ServiceEvent.EVENT_ERROR) {
        isErrorOccured=true;
    }else if(event.getEventCode()==ServiceEvent.EVENT_IN_PROGRESS) {
        StorageObject[] storeObjs=event.getCreatedObjects();
        for(StorageObject storeObj : storeObjs) {
            s3ObjsCompleted.add(storeObj.getKey());
        }
        ThreadWatcher watcher = event.getThreadWatcher();
        if (watcher.getBytesTransferred() >= watcher.getBytesTotal()) {
            logger.debug("Upload Completed.. Verifying");
        }else {
            int percentage = (int) (((double) watcher.getBytesTransferred() / watcher.getBytesTotal()) * 100);

            long bytesPerSecond = watcher.getBytesPerSecond();
            StringBuilder transferDetailsText=new StringBuilder("Uploading.... ");
            transferDetailsText.append("Speed: " + byteFormatter.formatByteSize(bytesPerSecond) + "/s");

            if (watcher.isTimeRemainingAvailable()) {
                long secondsRemaining = watcher.getTimeRemaining();
                if (transferDetailsText.length() > 0) {
                    transferDetailsText.append(" - ");
                }
                transferDetailsText.append("Time remaining: " + timeFormatter.formatTime(secondsRemaining));
            }

            logger.debug(transferDetailsText.toString()+" "+percentage);
        }
    }else if(ServiceEvent.EVENT_COMPLETED==event.getEventCode()) {
        logger.debug("**********************************Upload Event Completed***********************************");
        if(isErrorOccured) {
            logger.debug("**********************But with errors, have to retry failed uploads**************************");
        }
    }
}