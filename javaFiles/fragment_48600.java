Query lQuery = entityMgr.createQuery("update ParamGenerique p set p.libelleParam = :dest where id = :key);
ParamGeneriqueKey key = new ParamGeneriqueKey();
key.setTypeParam("GESTION_MAIL");
key.setValeurParam("DESTINATAIRE");
lQuery.setParameter("dest", pDestinataire);
lQuery.setParameter("key", key);