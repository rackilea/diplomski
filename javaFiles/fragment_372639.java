public class AccountCriteriaBuilder {

        CriteriaBuilder cb;
        CriteriaQuery<Account> cq;

        // JOINS INSTANCE
        Root<Account> accountRoot;
        Join<Account,Person> personJoin;
        Join<Person,Address> personAddressJoin;

        public AccountCriteriaBuilder(CriteriaBuilder criteriaBuilder) {
            this.cb =  criteriaBuilder;
            this.cq = cb.createQuery(Account.class);
            this.accountRoot = cq.from(Account.class);
        }

        public CriteriaQuery buildQuery() {
            Predicate[] predicates = getPredicates();
            cq.select(accountRoot).where(predicates);
            return cq;
        }

        public Predicate[] getPredicates() {

           List<Predicate> predicates = new ArrayList<Predicate>();

           predicates.add(cb.equal(getPersonJoin().get(Person_.name), "Roger"));
           predicates.add(cb.greaterThan(getPersonJoin().get(Person_.age), 18));
           predicates.add(cb.equal(getPersonAddressJoin().get(Address_.country),"United States"));

           return predicates.toArray(new Predicate[predicates.size()]);
        }

        public Root<Account> getAccountRoot() {
            return accountRoot;
        }

        public Join<Account, Person> getPersonJoin() {
            if(personJoin == null){
                personJoin = getAccountRoot().join(Account_.person);
            }
            return personJoin;
        }

        public Join<Person, Address> getPersonAddressJoin() {
            if(personAddressJoin == null){
                personAddressJoin = getPersonJoin().join(Person_.address);
            }
            return personAddressJoin;
        }


}