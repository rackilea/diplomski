@Override
public List<Atividades> listAllAtividades() {
    session.openSession();
    return session.getCurrentSession()
                  .createSQLQuery("SELECT * FROM ATIVIDADES WHERE DATA_PREVISTA BETWEEN NOW() AND DATE_ADD(NOW(), INTERVAL 7 DAY)")
                  .addEntity(Atividades.class)
                  .list();
}