public enum RelationActiveEnum {
     public static RelationActiveEnum fromValue(int value) 
             throws IllegalArgumentException {
         try {
              return RelationActiveEnum.values()[value]
         } catch(ArrayIndexOutOfBoundsException e) {
              throw new IllegalArgumentException("Unknown enum value :"+ value);
         }
     }
}