@Override
public Detector.DetectionType onDetectionSuccess(DetectionFrame validFrame) {

    FaceIDDataStruct dataStruct = mDetector.getFaceIDDataStruct();
    if (dataStruct != null) {
        face = dataStruct.images.get("image_best");

        Intent intent = new Intent(LivenessActivity.this, UploadActivity.class);
        //facefileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
        //intent.putExtra("filePath", facefileUri.getPath());
        intent.putExtra("image_best",face);
        setResult(PAGE_INTO_LIVENESS, intent);

        startActivity(intent); // Remove this
        finish(); // LivenessActivity.this.finish()

    }

    if (face == null) {
        face = validFrame.getCroppedFaceImageData();
    }//do something with liveness face
return DetectionType.DONE;

}