@Bean
public ItemWriter<Pojo> itemWriter() {
    BackToBackPatternClassifier classifier = new BackToBackPatternClassifier();
    classifier.setRouterDelegate(new MyClassifier());
    classifier.setMatcherMap(new HashMap<String, ItemWriter<? extends Pojo>>() {
        {
            put("A", WriterA);
            put("B", WriterB);

        }
    });
    ClassifierCompositeItemWriter<Pojo> writer = new ClassifierCompositeItemWriter<Pojo>();
    writer.setClassifier(classifier);
    return writer;      
}