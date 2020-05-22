public List<User> getUsersByProfileType(List<String> profileTypes) {
        return userRepository.findAll(new Specification<User> () {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                final List<Predicate> predicates = new ArrayList<>();

                final Subquery<UserProfile> userProfileSubquery = query.subquery(UserProfile.class);
                final Root<UserProfile> userProfile = userProfileSubquery.from(UserProfile.class);

                // select up.username from users_profiles ...
                userProfileSubquery.select(userProfile.get("user").get("name"));
                // ... where up.profile in ('admin')
                userProfileSubquery.where(cb.trim(userProfile.get("profile").get("id")).in(profileTypes));

                // select u from users u where u.name in ...
                predicates.add(root.get("name").in(userProfileSubquery));

                return cb.and(predicates.toArray(new Predicate[predicates.size()])); 
            }
        });
   }