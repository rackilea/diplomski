CriteriaBuilder cb = entityManager.getCriteriaBuilder();
CriteriaQuery query = cb.createQuery(/* Your combined target type, e.g. MyQueriedBuildDetails.class, containing buildNumber, duration, code health, etc.*/);

Root<BuildDetails> buildDetailsTable = query.from(BuildDetails.class);
Join<BuildDetails, CopyQualityDetails> qualityJoin = buildDetailsTable.join(CopyQualityDetails_.build, JoinType.INNER);
Join<BuildDetails, DeploymentDetails> deploymentJoin = buildDetailsTable.join(DeploymentDetails_.build, JoinType.INNER);
Join<BuildDetails, TestDetails> testJoin = buildDetailsTable.join(TestDetails_.build, JoinType.INNER);

List<Predicate> predicates = new ArrayList<>();
predicates.add(cb.equal(buildDetailsTable.get(BuildDetails_.buildNumber), "1.0.0.1"));
predicates.add(cb.equal(buildDetailsTable.get(BuildDetails_.projectName), "Tera"));

query.multiselect(buildDetails.get(BuildDetails_.buildNumber),
                  buildDetails.get(BuildDetails_.buildDuration),
                  qualityJoin.get(CodeQualityDetails_.codeHealth),
                  deploymentJoin.get(DeploymentDetails_.deployedEnv),
                  testJoin.get(TestDetails_.testStatus));
query.where(predicates.stream().toArray(Predicate[]::new));

TypedQuery<MyQueriedBuildDetails> typedQuery = entityManager.createQuery(query);

List<MyQueriedBuildDetails> resultList = typedQuery.getResultList();