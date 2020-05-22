Post post = (Post) session.load(Post.class, new Long(123));
// at this point, post refers to a proxy object created by Hibernate
// in the background - no post or user data has been loaded from DB
post.getId();
// post still refers to the proxy object
User user = post.getUser();
// post is now loaded, but user not - it refers to a proxy object
String name = user.getName(); // Now the user data is loaded from DB