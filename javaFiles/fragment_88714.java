public Card byNumber(String number) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Card> cq = cb.createQuery(Card.class);

    Root<Card> card = cq.from(Card.class);
    Predicate equalPredicate = cb.equal(card.get(Card_.number), number);
    cq.where(equalPredicate);
    cq.select(card);
    return em.createQuery(cq).getSingleResult();
}