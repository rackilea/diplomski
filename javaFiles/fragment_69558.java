private static boolean shouldBeComparenByGroupCode(TemplateBean b1) {
     return !"UNATTACHED".equals(b1.getStatusCode()) &&
            !"FIELDSIMPLE".equals(b1.getRefRltshpTypeCode()) &&
            !"CUSTOM".equals(b1.getRefRltshpTypeCode()) &&
            !"FUNCTION".equals(b1.getRefRltshpTypeCode());
}