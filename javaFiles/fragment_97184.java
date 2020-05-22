@NodeEntity
class Mashape {

   // ...
   @RelatedToVia(type = RelTypes.Tag.TAG_ON_OBJECT_EVALUATION, direction = Direction.OUTGOING)
   private Set<TagOnObjectEvaluation> tagOnObjectEvaluations = new HashSet<TagOnObjectEvaluation>();    

}