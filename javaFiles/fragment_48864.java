// @Transactional  // Remove the transactional annotation to avoid cascade issues!
public User getUserById(Long id) {
    List<ImageEntity> images;
    List<Tuple> tuples;
    User user;

    tuples = repository.getUserById(id);
    user   = null;

    if (!tuples.isEmpty()) {
        user   = tuples.get(0).get(0, User.class);
        images = new ArrayList<>();

        for (Tuple t : tuples) {
            if (t.get(1) != null) {
                images.add(new ImageEntity(
                    t.get(1, Long.class),
                    t.get(2, String.class)
                ));
            }
        }
        user.setImages(images);
    }
    return user;
}