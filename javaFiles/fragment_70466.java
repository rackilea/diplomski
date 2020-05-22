val tfResult = session.runner()
for(key, value : inputs) {
    tfResult = tfResult(key, value)
}
tfResult = tfResult.fetch("PartitionedCall")
  .run()
  .get(0)
  .expect(classOf[java.lang.Float])