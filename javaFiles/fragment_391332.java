import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext
import java.util.zip.{ZipEntry, ZipInputStream}
import org.apache.spark.input.PortableDataStream
import scala.collection.mutable
val conf = new SparkConf().setMaster("local").setAppName("ZipToSeq")
val sc = new SparkContext(conf)
val sqlContext = new SQLContext(sc)
var xml_map = new mutable.HashMap[String, String]()
sc.binaryFiles("/user/cloudera/test/2018-06-26.zip").collect
   .foreach { zip_file : (String, PortableDataStream) =>
   val zip_stream : ZipInputStream = new ZipInputStream(zip_file._2.open)
   var zip_entry : ZipEntry = null
   while ({zip_entry = zip_stream.getNextEntry; zip_entry != null}) {
      if (!zip_entry.isDirectory) {
      val key_file_name = zip_entry.getName
      val value_file_content = scala.io.Source.fromInputStream(zip_stream, "iso-8859-1").getLines.mkString("\n")
      xml_map += ( key_file_name -> value_file_content )
   }
   zip_stream.closeEntry()
  }
  zip_stream.close()
}
val xml_rdd = sc.parallelize(xml_map.toSeq, 75).saveAsSequenceFile("/user/cloudera/2018_06_26")