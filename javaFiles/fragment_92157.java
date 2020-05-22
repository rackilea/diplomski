setup() {
  buffer = new Buffer<String>(1_000_000);
}

map(LongWritable key, Text value) {
  buffer.append(value.toString())
  if (buffer.isFull()) {
    new Transaction(buffer).doIt()
    buffer.clear()
  }
}

cleanup() {
  new Transaction(buffer).doIt()
  buffer.clear()
}