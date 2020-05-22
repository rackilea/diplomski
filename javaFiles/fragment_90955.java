public Images getRandomImagesInGallerys(String[] galleryList) {

    String query = "from Images ";
    boolean first = true;

    for(String string : galleryList) {
        if(first){
            query+="where '"+string+"' member of galleries ";
            first=false;
        } else {
            query+="or '"+string+"' member of galleries ";
        }
    }

    entityManager.createQuery(query, Images.class).getResultList();
}