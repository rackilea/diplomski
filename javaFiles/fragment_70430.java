public void update(BookDescriptions bookDescription) {

if (this.entityManager.getTransaction().isActive()) {
    this.entityManager.getTransaction().rollback();
}
this.entityManager.saveOrUpdate(bookDescription);
}