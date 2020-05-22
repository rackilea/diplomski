private void getUsersPic() {
        Bitmap profilePic;

        try {
            InputStream in = new URL(AppData.getUser().getPicture()).openConnection().getInputStream();
            profilePic = BitmapFactory.decodeStream(in);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            profilePic.compress(Bitmap.CompressFormat.PNG, 100, stream);

            SaveBitmapToFile.saveBitmap(stream.toByteArray() , AppData.getUser().getName()+AppData.getUser().getLastName());

        } catch(Exception e) {
            System.out.println("Get profile pic: "+e.toString());
        }
    }