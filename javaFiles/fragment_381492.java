@Controller
public class PostController {
    @Autowired
    private PostCommentService postCommentService;

    @Autowired
    private PostService postService;

    //...
    @RequestMapping(value = "/something", method = RequestMethod.GET)
    public void foo() {
        Post post = postService.findById(1L);

        postCommentService.setCommentsInPost(post,0,10);

        //...
    }
    //...
}