Imports: { import static gate.Utils.*; }
Phase: SetPerPage
Input: Age X Y // and whatever other annotation types you want to copy
Options: control = all

Rule: MoveToPageSet
({Age}|{X}|{Y}):entity
-->
:entity {
  try {
    for(Annotation e : entityAnnots) {
      // find the (only) Page annotation that covers this entity
      Annotation thePage = getOnlyAnn(getCoveringAnnotations(inputAS, e, "Page"));
      // get the corresponding annotation set
      AnnotationSet pageSet = doc.getAnnotations(
              (String)thePage.getFeatures().get("id"));
      // and copy the annotation into it
      pageSet.add(start(e), end(e), e.getType(), e.getFeatures());
    }
  } catch(InvalidOffsetException e) {
    throw new JapeException("Invalid offset from existing annotation", e);
  }
  // optionally remove from input set
  // inputAS.removeAll(entityAnnots);
}