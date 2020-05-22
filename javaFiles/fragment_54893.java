import java.io.{DataOutputStream, ByteArrayOutputStream}
import java.lang.String
import org.apache.hadoop.hbase.client.Scan
import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.io.ImmutableBytesWritable
import org.apache.hadoop.hbase.client.Result
import org.apache.hadoop.hbase.mapreduce.TableInputFormat
import org.apache.hadoop.hbase.util.Base64

def convertScanToString(scan: Scan): String = {
  val out: ByteArrayOutputStream = new ByteArrayOutputStream
  val dos: DataOutputStream = new DataOutputStream(out)
  scan.write(dos)
  Base64.encodeBytes(out.toByteArray)
}

val conf = HBaseConfiguration.create()
val scan = new Scan()
scan.setCaching(500)
scan.setCacheBlocks(false)
conf.set(TableInputFormat.INPUT_TABLE, "table_name")
conf.set(TableInputFormat.SCAN, convertScanToString(scan))
val rdd = sc.newAPIHadoopRDD(conf, classOf[TableInputFormat], classOf[ImmutableBytesWritable], classOf[Result])
rdd.count