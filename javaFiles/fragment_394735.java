List<Photo> photos = (List<Photo>)
    em.createQuery(
    "select p
    from Photo p
    join fetch p.gallery g
    join fetch g.user u
    where p.id in (:photoIds)")
.setParameter("photoIds", photoIds) 
.getResultList();