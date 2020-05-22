yoursRDD.mapPartitions(iter => {
   val fs = FileSystem.get(new Configuration())
   val ds = fs.create(new Path("outfileName_" + TaskContext.get.partitionId))
   ds.writeBytes("Put yours results")
   ds.close()
   iter
})