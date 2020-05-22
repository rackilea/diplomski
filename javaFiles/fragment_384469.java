val distinct_tweets=hiveCtx.sql(" select distinct(text) from tweets_table where text <> ''")
val distinct_tweets_op=distinct_tweets.collect()
val distinct_tweets_list=sc.parallelize(List(distinct_tweets_op))
val distinct_tweets_string=distinct_tweets.map(x=>x.toString)

val test_kali=distinct_tweets_string.flatMap(line =>line.split(" ")).map(word => (word,1)).reduceByKey(_+_).sortBy {case (key,value) => -value}.map { case (key,value) => Array(key,value).mkString(",") }
test_kali.collect().foreach(println)

case class kali_test(text: String)
val test_kali_op=test_kali.map(_.split(" ")).map(p => kali_test(p(0)))
test_kali_op.registerTempTable("kali_test")
hiveCtx.sql(" select * from kali_test limit 10 ").collect().foreach(println)