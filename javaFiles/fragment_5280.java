public List<TopUpRAMSInfo> listadoTOPUP2(Date fechaI, Date fechaF) {

    List<TopUpRAMSInfo> lista;

    CriteriaQuery<TopUpRAMS> data = cb.createQuery(TopUpRAMSInfo.class);
    Root<TopUpRAMS> c = data.from(TopUpRAMS.class);
    data.select(cb.construct(TopUpRAMSInfo.class,
            c.get("deviceId"), 
            cb.sum(c.get("rechargeValue"))
        )
    );
    data.where(cb.greaterThanOrEqualTo(c.get("connectionTime"), fechaI),
        cb.lessThanOrEqualTo(c.get("connectionTime"), fechaF)
    );
    data.groupBy(c.get("deviceId"));

    TypedQuery<TopUpRAMSInfo> datos = emDAO.createQuery(data);
    lista = datos.getResultList();
    return lista;
}