String postId = rs.getString("post_id")
String liker =  rs.getString("people_who_like");

if(StringUtils.isEmpty(postId) && StringUtils.isEmpty(postId)) {
    liked = true;
} else {
    liked = false;
}