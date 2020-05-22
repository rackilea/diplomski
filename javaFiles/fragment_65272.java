public List<Factura> getAll() {
    Criteria criteria = getSession().createCriteria(Factura.class);
    criteria.add(
            Restrictions.not(
                    Restrictions.in("estado", new String[]{"RESERVADO"})));
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    List<Factura> list = criteria.list();
    return list;
}