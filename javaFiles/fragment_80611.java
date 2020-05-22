public void delete(Cat cat) {
    if(!entityManager.contains(cat)) {
        entityManager.merge(cat);
    }

    entityManager.remove(cat);
}