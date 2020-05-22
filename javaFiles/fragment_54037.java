SparkSession spark = SparkSession
              .builder()
              .appName("SparkCassandraApp")
              .config("spark.cassandra.connection.host", "localhost")
              .config("spark.cassandra.connection.port", "9042")
              .master("local[2]")
              .getOrCreate();

CassandraConnector connector = CassandraConnector.apply(spark.sparkContext().conf());
Session session = connector.openSession();
session.execute("CREATE TABLE mykeyspace.mytable(id UUID PRIMARY KEY, username TEXT, email TEXT)");