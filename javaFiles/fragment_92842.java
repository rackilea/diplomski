if (android.os.Build.VERSION.SDK_INT >= 29){
    // To handle deprication use   
    ImageDecoder.decodeBitmap(Imagedecoder.createSource())
} else{
    // Use older version
    MediaStore.Images.Media.getBitmap(contentResolver, imageUri)
}