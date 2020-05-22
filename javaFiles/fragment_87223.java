@Component
public class CreatorCheck {

    public boolean check(Post post, Authentication authentication) {
       return post.getCreator().equals(authentication.getName());
    }
}