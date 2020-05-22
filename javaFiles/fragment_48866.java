public List<User> findAll(Long id) {
    List<ImageEntity> images;
    List<Tuple> tuples;
    Map<Long, User> index;

    tuples = repository.findAll();
    index  = new HashMap<>();

    for (Tuple t : tuples) {
        user = t.get(0, User.class);

        if (!index.containsKey(user.getId()) {
            images = new ArrayList<>();

            user.setImages(images);
            index.put(user.getId(), user)
        } else {
            user   = index.get(user.getId());
            images = user.getImages():
        } 

        if (t.get(1) != null) {
            images.add(new ImageEntity(
               t.get(1, Long.class),
               t.get(2, String.class)
            ));
        }
    }
    return index.values();
}