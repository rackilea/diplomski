@Override
        public Account findOne(String id) {
            Account account = dbOperations.getMongoOpertion().findOne(Query.query(Criteria.where("_id").is(id)),
                    Account.class, "account");
            return account;
        }

@Override
    public void delete(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Account account = dbOperations.getMongoOpertion().findOne(query, Account.class);
        dbOperations.getMongoOpertion().remove(account);

    }