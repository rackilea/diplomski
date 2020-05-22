private void uploadImageToServer(String imagePath) {
        if (imagePath == null || imagePath.equals("")) {
            return;
        } else {
            showpDialog();
            Map<String, RequestBody> map = new HashMap<>();
            File file = new File(imagePath);

            if(file != null && file.exists() && file.canRead()) {
                try {
                    String compressedFileName = "_" + file.getName();

                    compressedImage = new Compressor(getActivity())
                            .setMaxWidth(2000)
                            .setMaxHeight(1400)
                            .setQuality(90)
                            .setCompressFormat(Bitmap.CompressFormat.JPEG)
                            .setDestinationDirectoryPath(Environment.getExternalStoragePublicDirectory(
                                    Environment.DIRECTORY_PICTURES).getAbsolutePath())
                            .compressToFile(file, compressedFileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
}