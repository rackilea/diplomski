private static ClassName RUN_WITH=ClassName.get("org.junit.runner", "RunWith");
  private static ClassName ANDROID_JUNIT4=ClassName.get("android.support.test.runner", "AndroidJUnit4");

  private TypeSpec buildTestClass() {
    return TypeSpec.classBuilder("MainActivityTest")
      .addModifiers(Modifier.PUBLIC)
      .addAnnotation(AnnotationSpec.builder(RUN_WITH)
        .addMember("value", "$T.class", ANDROID_JUNIT4)
        .build())
      .build();
  }