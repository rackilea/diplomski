public void update(BookDescriptions bookDescription) {

if (this.entityManager.getTransaction().isActive()) {
    this.entityManager.getTransaction().rollback();
}
this.entityManager.getTransaction().begin();
this.entityManager.update(bookDescription);
this.entityManager.getTransaction().commit();

}