@ApiModel(description = "Your comment")
public class Demand implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(notes = "Your comments", required = true, example = "example value")
    private String demandId;
}