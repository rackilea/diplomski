public final @Nullable InputStream openInputStream(@NonNull Uri uri)


   override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (this.imageUri != null && requestCode == IMAGE_PICK_CODE && resultCode == RESULT_OK) {

            try {
                //Getting the Bitmap from Gallery
                val bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, this.imageUri) as Bitmap
                this.imgThumb!!.setImageBitmap(bitmap)
                this.pictureTaken = true
            } catch (e:IOException) {
                e.printStackTrace()
            }
        } else {
            Toast.makeText(context, "Error loading image", Toast.LENGTH_LONG)
        }
    }