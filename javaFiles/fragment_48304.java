public WriteObjectResult write(File localTempFile, long jobId) {
    // cheap operation to check if the manifest is already there
    if (manifestsExists()) {
         long manifestJobId = Integer.parseInt(getManifestMetadata().get("jobId"));
         if (manifestJobId == jobId) {
             log.warn("Job " + jobId + " has already completed successfully and published a manifest. Ignoring write request."
             return null;
         }
         log.info("A manifest has already been published by job " + jobId + " for this dataset. Invalidating manifest.");
         deleteExistingManifest();
    }    
    return publish(localTempFile);
}