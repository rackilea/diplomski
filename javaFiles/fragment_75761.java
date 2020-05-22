public Optional<Tag> retrieveTagByValue(String tagValue) {
    try {
        Tag tag = em.createNamedQuery("Tag.findByValue", Tag.class)
                .setParameter("tagValue", tagValue)
                .getSingleResult();
        return Optional.of(tag);
    } catch (NoResultException e) {
        System.out.println(e.getMessage());
        return Optional.empty();
    }
}