@ModelAttribute("backingObject")
public SuperClass getBackingObject(HttpRequest request //etc) {
  //determine value of your path variable
  //create appropriate subcass
  return subClassInstanceForBinding;
}