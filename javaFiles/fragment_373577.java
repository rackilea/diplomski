Dataset<Row> tstDS = spark.read().format("csv").option("header", "true").load("/home/exa9/Documents/SparkLogs/y.csv");

              tstDS.show();

/****
+---+-----+------+----------+
|  A|A_SRC|Past_A|Past_A_SRC|
+---+-----+------+----------+
| a1|   s1|    a2|        s2|
+---+-----+------+----------+

****/
              tstDS.withColumn("A", 


                      functions.to_json( 
                              functions.struct(

                                      functions.col("A").as("source"),
                                      functions.col("A_SRC").as("value"),
                                      functions.col("Past_A").as("p_source"),
                                      functions.col("Past_A_SRC").as("p_value")

                                      ))
                      )
              .select("A")
              .show(false);

/****

+-----------------------------------------------------------+
|A                                                          |
+-----------------------------------------------------------+
|{"source":"a1","value":"s1","p_source":"a2","p_value":"s2"}|
+-----------------------------------------------------------+

****/