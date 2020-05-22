public void excluir(Object obj) {
    getSession().beginTransaction();
    getSession().delete(obj);
    getSession().getTransaction().commit();
    getSession().close();
}