@Document
@CompoundIndexes(value = { @CompoundIndex(name = "post_vote_user_idx", def = "{'postId':1, 'user':1}", unique = true) })
public class PostVote implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 6690216554403820228L;
    private String            id;
    @Indexed
    private String            postId;
    @DBRef
    private User              user;

[
    {
        "v" : 1,
        "key" : {
            "_id" : 1
        },
        "name" : "_id_",
        "ns" : "mongotest.postVote"
    },
    {
        "v" : 1,
        "unique" : true,
        "key" : {
            "postId" : 1,
            "user" : 1
        },
        "name" : "post_vote_user_idx",
        "ns" : "mongotest.postVote",
        "sparse" : false
    },
    {
        "v" : 1,
        "key" : {
            "postId" : 1
        },
        "name" : "postId",
        "ns" : "mongotest.postVote",
        "sparse" : false
    }
]