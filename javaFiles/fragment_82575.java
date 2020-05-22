public interface PessoaSpecifications {

    static <Pessoa> Specification<Pessoa> byCpf(String someCpf) {
        return new Specification<Pessoa> {
            public Predicate toPredicate(Root<Pessoa> root, CriteriaQuery query, CriteriaBuilder cb) {
                return cb.equal(root.get(Customer_.cpf), someCpf);
            }
        };
    }
}