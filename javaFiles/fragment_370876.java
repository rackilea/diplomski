public class QuickTest {
public static void main(String[] args) {
    SparkSession sparkSession = SparkSession
            .builder()
            .appName("QuickTest")
            .master("local[*]")
            .getOrCreate();
    //StructType
    StructType st1 = new StructType().add("name", DataTypes.StringType);
    System.out.println("hashCode "+st1.hashCode());
    System.out.println("structType "+st1.toString());

    //add
    st1.add("age", DataTypes.IntegerType);
    System.out.println("hashCode "+st1.hashCode());
    System.out.println("structType "+st1.toString());

    //add and assign
    StructType st2 = st1.add("age", DataTypes.IntegerType);
    System.out.println("hashCode "+st2.hashCode());
    System.out.println("structType "+st2.toString());

    //constructor
    StructType st3 = new StructType(new StructField[] {new StructField("name", DataTypes.StringType, true, null), new StructField("age", DataTypes.IntegerType, true, null)});
    System.out.println("hashCode "+st3.hashCode());
    System.out.println("structType "+st3.toString());
  }
}