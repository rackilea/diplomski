new ByteBuddy()
  .redefine(ClassThatNeedsToBeAnnotated.class)
  .visit(new MemberAttributeExtension.ForMethod()
    .annotateMethod(someAnnotation)
    .on(matcher))
  .make();