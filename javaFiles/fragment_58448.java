SparkContext context = new SparkContext(new SparkConf().setAppName("spark-ml").setMaster("local[*]")
                .set("spark.hadoop.fs.default.name", "hdfs://localhost:54310").set("spark.hadoop.fs.defaultFS", "hdfs://localhost:54310")
                .set("spark.hadoop.fs.hdfs.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName())
                .set("spark.hadoop.fs.hdfs.server", org.apache.hadoop.hdfs.server.namenode.NameNode.class.getName())
                .set("spark.hadoop.conf", org.apache.hadoop.hdfs.HdfsConfiguration.class.getName()));
        this.session = SparkSession.builder().sparkContext(context).getOrCreate();