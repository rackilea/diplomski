@Autowired
private CreatorCheck creatorCheck;

@PutMapping
@PreAuthorize("@creatorChecker.check(#post,authentication)")
public void update(@RequestBody Post post, Authentication authentication) {
    service.updatePost(post);
}