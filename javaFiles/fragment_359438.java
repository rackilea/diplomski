Dataset<Row> df = spark.read()
                .csv("iris.csv")
                .toDF("sepal.length","sepal.width","petal.length","petal.width","variety");


System.out.println(df.showString(3, 0, true));

-RECORD 0--------------
 sepal.length | 5.1    
 sepal.width  | 3.5    
 petal.length | 1.4    
 petal.width  | 0.2    
 variety      | setosa 
-RECORD 1--------------
 sepal.length | 4.9    
 sepal.width  | 3      
 petal.length | 1.4    
 petal.width  | 0.2    
 variety      | setosa 
-RECORD 2--------------
 sepal.length | 4.7    
 sepal.width  | 3.2    
 petal.length | 1.3    
 petal.width  | 0.2    
 variety      | setosa 
 only showing top 3 rows

System.out.println(df.showString(3,1,false));

+------------+-----------+------------+-----------+-------+
|sepal.length|sepal.width|petal.length|petal.width|variety|
+------------+-----------+------------+-----------+-------+
|           5|          3|           1|          0|      s|
|           4|          3|           1|          0|      s|
|           4|          3|           1|          0|      s|
+------------+-----------+------------+-----------+-------+
only showing top 3 rows