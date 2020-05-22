@Service
public class PostCommentServiceImpl {

    @Autowired
    private PostCommentRepository repository;

    //...

    public void setCommentsInPost(Post post, int first, int size){
        Pageable pageRequest = new PageRequest(first, size);

        Page<PostComment> pageOfPostComment = repository.findByPostId(post.getId(), pageRequest);

        post.setComments(pageOfPostComment.getContent());
    }
}