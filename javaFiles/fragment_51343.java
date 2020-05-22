val HighPrecision = new java.math.MathContext(36, java.math.RoundingMode.HALF_EVEN);
val TargetPrecision = java.math.MathContext.DECIMAL128;

val a = BigDecimal(1, HighPrecision)
val N = BigDecimal(3, HighPrecision)
(a/N*N).round(TargetPrecision) == a.round(TargetPrecision)