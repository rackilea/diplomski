List<Object[]> results = userDao.findUserAndPost(userId, postId);

    for (int i = 0; i < results.size(); i++) {

        User user = (results.get(i)[0] instanceof User) ? (User) results.get(i)[0] : null;
        Post post = (results.get(i)[1] instanceof Post) ? (Post) results.get(i)[1] : null;

        // Do whatever with user and post...
    }