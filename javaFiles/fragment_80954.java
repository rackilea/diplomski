Object[] result = entityManager.createQuery("select dd, MAX(dd.createdMillis) from T_DEBIT dd" +              
                " where dd.debitStatus in (:debitStatus)" +
                " and dd.account = :account" , Object[].class) //Notice change
                .setParameter("debitStatus", false)
                .setParameter("account", account)
                .getSingleResult();