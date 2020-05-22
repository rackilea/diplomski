AnnotationSet contTagAS = getContainedAnnotations(inputAS,spanAs).get("all_tags");

StringJoiner joiner = new StringJoiner(",");

for (Annotation tagAnn : contTagAS.inDocumentOrder())
{
  FeatureMap lookupFeatures  = tagAnn.getFeatures();
  String tag = lookupFeatures.get("type").toString();
  joiner.add(tag);
}

outputAS.add(
    spanAs.firstNode(), 
    spanAs.lastNode(), 
    "new annotation", 
    featureMap("tags", joiner.toString())
);