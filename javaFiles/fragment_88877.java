try {
   Configuration conf = new Configuration();
   conf.set("fs.s3a.access.key", "ACCESSKEY");
   conf.set("fs.s3a.secret.key", "SECRETKEY");
   //Below are some other helpful settings
   //conf.set("fs.s3a.endpoint", "s3.amazonaws.com");
   //conf.set("fs.s3a.aws.credentials.provider", "org.apache.hadoop.fs.s3a.SimpleAWSCredentialsProvider");
   //conf.set("fs.hdfs.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName()); // Not needed unless you reference the hadoop-hdfs library.
   //conf.set("fs.file.impl", org.apache.hadoop.fs.LocalFileSystem.class.getName()); // Uncomment if you get "No FileSystem for scheme: file" errors

   Path path = new Path("s3a://your-bucket-name/examplefolder/data.parquet");

   //Use path below to save to local file system instead
   //Path path = new Path("data.parquet");

   try (ParquetWriter writer = AvroParquetWriter.builder(path)
           .withSchema(avroSchema)
           .withCompressionCodec(CompressionCodecName.GZIP)
           .withConf(conf)
           .withPageSize(4 * 1024 * 1024) //For compression
           .withRowGroupSize(16 * 1024 * 1024) //For write buffering (Page size)
           .build()) {
       //We only have one record to write in our example
       writer.write(record);
   }
} catch (Exception ex) { ex.printStackTrace(System.out); }