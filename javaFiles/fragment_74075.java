// val geometry = GeometrySerializer.deserialize(
//  inputExpressions(0)         // get value with index 0 in Seq
//    .eval(input)              // call "eval" method on that value
//    .asInstanceOf[ArrayData]  // cast to ArrayData
//)
ArrayData ad = (ArrayData) inputExpressions.apply(0).eval(input);
Geometry g = GeometrySerializer.deserialize(ad);