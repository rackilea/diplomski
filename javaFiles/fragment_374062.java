/*
 * parentAnnotation, @JoinColumns object
 * memberName, "value"
 * memberValue, {@JoinColumn,...} object
 */ 
public void addMemberToAnnotation(Annotation parentAnnotation String memberName, Object memberValue){
    if(memberValue instanceof Annotation[]){
        ArrayList<AnnotationMemberValue> members = new ArrayList<AnnotationMemberValue>();
        AnnotationMemberValue annotationValue;
        for (Annotation a:(Annotation[])memberValue) {
            annotationValue =  new AnnotationMemberValue(cb.getCpool());
            annotationValue.setValue(a);
            members.add(annotationValue);
        }
        ArrayMemberValue arrayValue = new ArrayMemberValue(cb.getCpool());
        arrayValue.setValue(members.toArray(new MemberValue[0]));
        parentAnnotation.addMemberValue(memberName, arrayValue);
    } else if ( ... ){
        // Other cases
    }
}