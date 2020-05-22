List<Integer> myTagsIds = new ArrayList<Integer> ();
myTagsIds.add(1);
myTagsIds.add(2);

CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<BlogPost> cq = cb.createQuery(BlogPost.class);
Root<BlogPost> blogPost = cq.from(BlogPost.class);
SetJoin<BlogPost, Tag> tags = blogPost.join(BlogPost_.tags);
Predicate predicate = tags.get(Tag_.id).in(myTagsIds);
cq.distinct(true);
cq.where(predicate);
TypedQuery<BlogPost> tq = em.createQuery(cq);
return tq.getResultList();