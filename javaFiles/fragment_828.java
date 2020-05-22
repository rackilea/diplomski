@Component
public class MyTasklet implements Tasklet {

    @Autowired
    private ItemReader<YourType> readerSpringBeanName;

    @Autowired
    private ItemProcessor<List<YourType>,List<YourType>> processorSpringBeanName;

    @Autwired
    private ItemWriter<List<YourType>> writerSpringBeanName;


    RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        readerSpringBeanName.open(new ExecutionContext());
        writerSpringBeanName.open(new ExecutionContext());

        List<YourType> items = new ArrayList<>();
        YourType readItem = readerSpringBeanName.read();
        while(readItem != null) {
             items.add(readItem);
             readItem = readerSpringBeanName.read();
        }

        writerSpringBeanName.write(processorSpringBeanName.process(items));

        readerSpringBeanName.close();
        writerSpringBeanName.close();
        return RepeatStatus.FINISHED;
    }
}