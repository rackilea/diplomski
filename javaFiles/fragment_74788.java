@Document
@CompoundIndexes(value = { @CompoundIndex(name = "post_vote_user_idx", def = "{'postId':1, 'user':1}", unique = true) })
public class PostVote implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 6690216554403820228L;
    private String id;
    @NotEmpty
    private String postId;
    @NotEmpty
    private String ownerEmail;
    @NotEmpty
    private String postTypeCode;
    private String parentId;
    @NotEmpty
    private String voteTypeId;
    @NotNull
    @DBRef
    private User user;
    // Rest of the class follows