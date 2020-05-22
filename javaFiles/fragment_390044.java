layout = layout.replaceAll("\"empty\",?", "").replaceAll("^\"|\"$", "").replaceAll("\\],\\[", "\\]-\\[");
    String[] layoutArray = layout.split("-");

try {
    for (int i = 0; i < layoutArray.length; i++) {
        layoutArray[i]= layoutArray[i].replaceAll("[\\[\"\\]]","");
        String[] splitted = layoutArray[i].split(",");
        for (int j = 0; j < splitted.length; j++) {
            int imageIndex = Integer.valueOf(splitted[j]) - 1;
            String imageFile = splitted[imageIndex];
            Bitmap image = BitmapFactory.decodeFile(new File(getFilesDir(), imageFile).getAbsoluteFile().toString());
            mImageList.add(new Grid(getApplicationContext(), i, j, image, imageFile));

        }
    }
} catch (Exception e) {
    e.printStackTrace();
}