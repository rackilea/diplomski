// scala and java
exploded_df
  .groupBy(col("col.c"))
  .pivot("names")
  .agg(first(col("col.v")))
  .orderBy("c")
  .show();
+-----+------+---+-----+
|    c|absRho|lag|  rho|
+-----+------+---+-----+
|rho_0|     1|  0|    1|
|rho_1|  0.89|  1| 0.89|
|rho_2|  0.66|  2| 0.66|
|rho_3| 0.074|  3|0.074|
+-----+------+---+-----+