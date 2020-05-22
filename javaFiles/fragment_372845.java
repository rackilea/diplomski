public class YourAnnotations {
  @AutoAnnotation public static YourAnnotation yourAnnotation(String foo) {
    return new AutoAnnotation_YourAnnotations_yourAnnotation(foo);
  }
}

public class ClassPreambles {
  @AutoAnnotation public static ClassPreamble classPreamble(
      String author,
      String date,
      int currentRevision,
      String lastModified,
      String lastModifiedBy,
      String[] reviewers) {
    return new AutoAnnotation_ClassPreambles_classPreamble(
        author,
        date,
        currentRevision,
        lastModified,
        lastModifiedBy,
        reviewers);
  }
}