interface MyDao extends GetHandle {
  default int search(MyBean bean) {
    return getHandle().createQuery(
            "SELECT id FROM myTable WHERE value = :bean.one")
        .bindFromProperties(bean)
        .mapTo(int.class)
        .first();
  }
}