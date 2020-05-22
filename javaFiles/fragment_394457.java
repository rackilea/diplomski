public List<Cerere> nrConturi(String jud, String aplic, String oper) {

        List<Cerere> list = null;
        String numeJud = scoateNumeJudetDupaCod(jud);

        StringBuilder queryBuilder = new StringBuilder("select c from DetaliiCerere c");

        if (!aplic.equals("")) {
            queryBuilder.append(" join c.aplicatii a where a.id in (");
            queryBuilder.append(aplic);
            queryBuilder.append(")");
        } else {
            queryBuilder.append(" where");
        }

        if (!jud.equals("")) {
            if (!aplic.equals(""))
                queryBuilder = queryBuilder
                        .append(" and");

            queryBuilder = queryBuilder
                    .append(" upper(c.judet)=upper('")
                    .append(numeJud)
                    .append("')");
        }


        if (!oper.equals("")) {
            if (!aplic.equals("") || !jud.equals("")) {
                queryBuilder = queryBuilder
                        .append(" and");
            }

            queryBuilder = queryBuilder
                    .append(" upper(c.codFiscal) like upper('%")
                    .append(oper)
                    .append("%')");
        }

        queryBuilder = queryBuilder
                .append(" and c.status='Cerere aprobata'");

        String jpQL = queryBuilder.toString();
        LOG.debug("JPQL >> ... {}", jpQL);

        Query query = entityManager.createQuery(jpQL);
        list = query.getResultList();

        return list;
    }