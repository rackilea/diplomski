JavaSparkContext context  = ......;

    //Retrieve list of files from master file

    List<String> files = context.textFile("/somepath/catmydata.csv")
            .flatMap(row->Arrays.asList(row.split(",")).iterator()).collect();

   //Iterate through each file and save it as object file
   Map<String,JavaRDD<Cat>> adoptedCatsMap =new HashMap<String,JavaRDD<Cat>>();
    for (String file:files) {

       // Extract file path and attach to convert
        String output=String.format("/convertedcatdata/%s",file.substring(file.indexOf('/'),file.length()))

       JavaRDD<Cat> adoptedCatsRdd = context.textFile(file).map(s->new Cat(s));

       adoptedCatsMap.put(output,adoptedCatsRdd);
       //This will write number of files based on rdd partitions,
       // if you want only one file in a directory then save it 
       // to temporary directory then use copyMerge to create one file using Hadoop fs FileUtil
       // https://hadoop.apache.org/docs/r2.7.1/api/org/apache/hadoop/fs/FileUtil.html
      //Save to physical location if required.
       adoptedCatsRdd.saveAsObjectFile(output);
    }