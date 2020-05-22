public Set<Post> getUsersPosts(String username) {
    return userDao.findPostsByUsername(username);
}

// Only select posts from a user, without user entity. No JOIN needed.
@Query("SELECT u.posts FROM User u WHERE u.username = :username")
Set<Post> findPostsByUsername(@Param("username") String username);

// A Left join brings us the user even if it doesn't have posts, and 
// FETCH gets the posts eagerly, so no lazy loading or performance hit
@Query("SELECT u FROM User u LEFT JOIN FETCH u.posts WHERE u.username = :username")
User findUserAndPostsByUsername(@Param("username") String username);