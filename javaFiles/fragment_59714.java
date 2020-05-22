/**
 * Inject the internal email recipient, for monitoring and informational purposes.
 */
public class InjectInternalEmailRecipientTasklet implements Tasklet{

    public static final Float DEFAULT_MAX_AFFINITY_SCORE = 1.0f;

    private UserCategoryRepository userCategoryRepository;

    public InjectInternalEmailRecipientTasklet(RecipientRepository recipientRepository) {
        this.recipientRepository = recipientRepository;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        // We can safely inject this record even on non-prod environments because the email processor obfuscates all emails on
        // non-prod environments. N.B. we do not want the internal user to receive TEST emails/placements.

        recipeintRepository.bulkInsert(new Recipient("testemail@example.com");
        return RepeatStatus.FINISHED;
    }
}