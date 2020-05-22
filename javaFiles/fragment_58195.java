public List<Collaborator> getCollaborators(Long answerId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Collaborator> criteriaQuery = criteriaBuilder
                .createQuery(Collaborator.class);
        Root<Answer> answerRoot = criteriaQuery.from(Answer.class);
        criteriaQuery.where(criteriaBuilder.equal(answerRoot.get(Answer_.id),
                answerId));
        SetJoin<Answer, Collaborator> answers = answerRoot
                .join(Answer_.collaborators);
        CriteriaQuery<Collaborator> cq = criteriaQuery.select(answers);
        TypedQuery<Collaborator> query = entityManager.createQuery(cq);
        return query.getResultList();

    }