DetachedCriteria dCriteriaEt1 = DetachedCriteria.forClass(EquityTransaction.class, "et1")
                    .add(Restrictions.eq("clientCompany.id", decldDvd.getClientCompany().getId()))
                    .add(Restrictions.le("transactionDate", decldDvd.getQualifyDate()))
                    .setProjection(Projections.projectionList()
                            .add(Projections.max("processedTransaction.id"), "processedTransaction.id"))
                    .add(Restrictions.eqProperty("et1.holderCompanyAccount.id", "et2.holderCompanyAccount.id"));

            logger.info("Retrieving all qualified company account balances...");
            Criteria getQualifiedBalances = dao.getSession().createCriteria(EquityTransaction.class, "et2")
                    .add(Subqueries.propertyIn("processedTransaction.id", dCriteriaEt1))
                    .add(Restrictions.gt("balance", 0l))
                    .setProjection(Projections.projectionList()
                            .add(Projections.property("holderCompanyAccount.id"),"holderCompanyAccount.id")
                            .add(Projections.property("balance"), "balance"))
                    .addOrder(Order.asc("holderCompanyAccount.id"))
                    .addOrder(Order.desc("processedTransaction.id"))
                    .setResultTransformer(new AliasToBeanNestedResultTransformer(EquityTransaction.class));