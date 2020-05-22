import org.apache.hadoop.fs.{FileSystem, Path}

datasetOfImages.foreachPartition { images =>
  val fs = FileSystem.get(sparkContext.hadoopConfiguration)
  images.foreach { image =>
    val out = fs.create(new Path("/path/to/this/image"))
    out.write(image);
    out.close();
  }
}