import java.io.{File, FileWriter}
import util.Try

val writer = Try(new FileWriter(new File("filename.csv")))
writer.map{w => w.write(allData.mkString); w}
      .recoverWith{case e => e.printStackTrace(); writer}
      .map(_.close())