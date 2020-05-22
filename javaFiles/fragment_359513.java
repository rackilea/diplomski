@Override
public List<Link> getLinksByTag(String tag){

    CriteriaBuilder cBuilder = getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Link> criteria = cBuilder.createQuery( Link.class );
    Root<Link> linkRoot = criteria.from( Link.class );
    Join<Link, LinkDetails> linkDetailsJoin = linkRoot.join(Link_.linkDetails);
    Join<LinkDetails, Tag> tagJoin = linkDetailsJoin.join(LinkDetails_.tags);
    criteria.select(linkRoot);
    criteria.where(cBuilder.equal(tagJoin.get(Tag_.name), tag));
    TypedQuery<Link> query = getEntityManager().createQuery(criteria);
    return query.getResultList();
}