public Triangle(Triangle other) {
    super(neverNull(other).getPoints().clone());
}

private static <S extends Shape> S neverNull(S notNull) {
     if (notNull == null) {
         // throw a meaningful exception 
         // or return a default value for S if possible / reasonable
     }

     return notNull;
}