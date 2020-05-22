@Data
public class AnswerDTO {

    @Size(max=255, message="Text too long")
    @NotNull(message="Field text cannot be null")
    private String text;

}