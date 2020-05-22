public static Specification<Product> joinTest(SomeUser input) {
    return new Specification<Product>() {
        public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
            Join<Product,SomeUser> userProd = root.join("owner");
            Join<FollowingRelationship,Product> prodRelation = userProd.join("ownedRelationships");
            return cb.equal(prodRelation.get("follower"), input);
        }
    };
}