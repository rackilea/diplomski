@RestController
@RequestMapping(value="/questions")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping
    public void createQuestion(@RequestBody QuestionDTO questionDTO){
        Question question = convert(questionDTO);
        questionRepository.save(question);
    }
}