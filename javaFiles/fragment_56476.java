private Camera.PreviewCallback  previewCallback= new Camera.PreviewCallback()
{   
    @Override
    public void onPreviewFrame(byte[] data,Camera cam)
    {
            Camera.Size previewSize = cam.getParameters().getPreviewSize();
            YuvImage yuvImage = new YuvImage(data, ImageFormat.NV21,previewSize.width,previewSize.height, null);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0,0,previewSize.width,previewSize.height),80,baos);
            byte[] jdata = baos.toByteArray();
            Bitmap bitmap = BitmapFactory.decodeByteArray(jdata,0,jdata.length);    
    }
};