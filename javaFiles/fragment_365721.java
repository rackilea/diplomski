import org.apache.spark.sql.types.*;
import org.apache.spark.sql.expressions.UserDefinedFunction;
import static org.apache.spark.sql.functions.*;

UserDefinedFunction toarray = udf(
  (Vector v) -> v.toArray(),  new ArrayType(DataTypes.DoubleType, false)
);