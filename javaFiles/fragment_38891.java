public Photo searchByTitle(String title) {
    for(Photo photo : photos) {
        if (photo.getTitle().equals(title)){
           return photo;
        }
        return null;
    }

}