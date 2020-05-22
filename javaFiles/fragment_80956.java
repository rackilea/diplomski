Result result = entityManager.createQuery("select NEW fully.qualified.Result(dd, MAX(dd.createdMillis)) from T_DEBIT dd" +              
                " where dd.debitStatus in (:debitStatus)" +
                " and dd.account = :account" , Result.class)
                .setParameter("debitStatus", false)
                .setParameter("account", account)
                .getSingleResult();