public List getControle_versao(int controle) {

    return (List) session.getCurrentSession().createQuery(
        "FROM Receita WHERE controle = " + controle + " ORDER BY titulo").list();

}