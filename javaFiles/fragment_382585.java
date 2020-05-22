...

@Override
public List<PostMW> getFeed(int page, UserMW user) {
    List<PostMW> result;
    int offset = page * ConstUtil.FEED_POSTS_PER_PAGE;
    postDao.openCurrentSession();
    result = postDao.list(offset, ConstUtil.FEED_POSTS_PER_PAGE);

    List<Long> postIds = new ArrayList();

    for(PostMW post : result){           
       postIds.add(post.getid();
    }

   //then EXtract all liked post from list :
   Query queryIn = em.createQuery("SELECT p.post.id FROM LikeMW p WHERE p.user = :user AND p.post IN :values");

   queryIn.setParameter("values", postIds );
   queryIn.setParameter("user", currentUser);
   List<Object[]> resultIn = queryIn.getResultList();

   Set<Long> postIdLiked ) new HashSet<>();
   for(Object[] row: resultIn) {
       postIdLiked.add(row[0]);
   }
   //then fill the boolean isLiked  
   for(PostMW post : result){            
       if (postIdLiked.contains(post.getId()) 
          post.setLiked(true);      
   }

    postDao.closeCurrentSession();
    return result;
}

...