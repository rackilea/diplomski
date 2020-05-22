public class Grid {

    @SerializedName("category")
    @Expose
    private String category;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("title")
    @Expose
    private String title;

    @JsonAdapter(value = EquationListJsonAdapter.class)
    @SerializedName("equation_list")
    @Expose
    private EquationList equationList;

}