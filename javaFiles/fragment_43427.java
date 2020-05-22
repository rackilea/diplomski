WindowSpec specGroup = Window.partitionBy(col("groupId"))  
                             .orderBy(col("ID"));
WindowSpec specSeqGroupId = Window.partitionBy(col("groupId")) 
                                  .orderBy(col("ID"))
                                  .rowsBetween(Long.MIN_VALUE, 0);
WindowSpec specPrevDiff = Window.partitionBy(col("groupId"), col("seqGroupId"))
                                .orderBy(col("ID"))
                                .rowsBetween(Long.MIN_VALUE, 0);

df.withColumn("prevPhase", coalesce(lag("phaseName", 1).over(specGroup), lit("NO_PREV"))) 
  .withColumn("seqCount", when(col("prevPhase").equalTo(col("phaseName")).or(col("prevPhase").equalTo("NO_PREV")),0).otherwise(1))
  .withColumn("seqGroupId", sum("seqCount").over(specSeqGroupId))
  .withColumn("prevDiff", first("prevPhase").over(specPrevDiff));