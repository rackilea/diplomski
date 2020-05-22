public class PictureBean implements Serializable
{
    private static final long serialVersionUID = 6969933524911660214L;

    public enum CCLtype
    {
        BY, ND, CO, NN, SA
    }

    private String picture_rm;
    private String picture_url;
    private String picture_16_9_url;
    private String author;
    private String title;
    private String description;
    private String p_memo;
    private String p_original_rate;
    private String move_url;
    private int like_count;
    private int picture_exp_count;
    private List<JsonObject> tagList;
    private List<JsonObject> categoryList;
    private CCLtype ccl;
    private String picture_source;
    private boolean isUserLiked;
    private boolean isUserAdded;
}