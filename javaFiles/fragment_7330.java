AnnotationNode runtimeRetention = new AnnotationNode(ASM6, "Ljava/lang/annotation/Retention;");
runtimeRetention.values = Arrays.asList(
    "value", // parameter name; related value follows immediately next:
    new String[] { "Ljava/lang/annotation/RetentionPolicy;", "RUNTIME" } // enum type & value
);
cn.visibleAnnotations = Arrays.asList(runtimeRetention);