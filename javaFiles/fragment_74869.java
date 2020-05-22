private int currentPhotoIndex = 0;

public Photo next() {
    if (this.size() == 0) {
        return null;
    }

    if (this.currentPhotoIndex < this.size()) {
        this.currentPhotoIndex++;
    } else {
        this.currentPhotoIndex = 0;
    }

    //I think here it should be: return this.get(currentPhotoIndex), but I sticked to your code
    return PhotoAlbum.photo.get(currentPhotoIndex);

}

public Photo previous() {
    if (this.size() == 0) {
        return null;
    }
    if (this.currentPhotoIndex > 0) {
        this.currentPhotoIndex--;
    } else {
        this.currentPhotoIndex = this.size() - 1;
    }

    //I think here it should be: return this.get(currentPhotoIndex), but I sticked to your code
    return PhotoAlbum.photo.get(currentPhotoIndex);
}