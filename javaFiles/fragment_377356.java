import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.mllib.linalg.VectorUDT;

List<StructField> fields = new ArrayList<>();
fields.add(DataTypes.createStructField("id", DataTypes.StringType, false));
fields.add(DataTypes.createStructField("features", new VectorUDT(), false));
DataType schema = DataTypes.createStructType(fields);