@Data
public class QuestionDTO {

    @Size(max=1000, message="Text too long")
    @NotNull(message="Field text cannot be null")
    private String text;

    private List<AnswerDTO> answers;
}