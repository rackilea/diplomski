public class KafkaListenersTypeExcludeFilter extends TypeExcludeFilter {

  private static final String KAFKA_LISTENER = "org.springframework.kafka.annotation.KafkaListener";
  private static final String KAFKA_HANDLER = "org.springframework.kafka.annotation.KafkaHandler";

  @Override
  public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) {
    AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
    return annotationMetadata.hasAnnotatedMethods(KAFKA_LISTENER)
        || annotationMetadata.hasAnnotatedMethods(KAFKA_HANDLER);
  }

  @Override
  public boolean equals(Object o) {
    return o != null && getClass() == o.getClass();
  }

  @Override
  public int hashCode() {
    return 1;
  }
}