public EList<Annotation> getAnnotation()
{
  // Create the new list that will hold ALL the annotations
  EList<Annotation> annotations = new BasicEList<Annotation>();
  for (Sc currSc : sche)
  {
    for (EntityS entitys : ent)
    {
      // Get annotation
      annotations.addAll(entitys.getAnnotations());
    }
  }
  return annotations;
}