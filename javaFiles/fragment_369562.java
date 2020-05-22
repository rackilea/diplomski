@Column(name = "image_file")
private byte[] imageFile;

@Transient
private MultipartFile multiPartFile;

public void setMultiPartFile(MultipartFile multiPartFile) {
    this.multiPartFile = multiPartFile;
    if(multiPartFile != null){
        this.setImageFile(multiPartFile.getBytes());
    }
}