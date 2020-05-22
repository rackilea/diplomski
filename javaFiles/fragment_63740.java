abstract class YourBusinessObjectAssert{
  public static void assertYourBussinessObjectIsValid(YourBusinessObject pYourBusinessObject,       Collection<YourBusinessObject> pAllYourBusinessObject) {
for (YourBusinessObject lYourBusinessObject : pAllYourBusinessObject) {
  if (lYourBusinessObject.isTechnicalEqual(pYourBusinessObject)) {
    return;
  }
}
assertFalse("Could not find requested YourBusinessObject in List<YourBusinessObject>!", true);
}
}