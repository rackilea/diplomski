@RequestMapping(value=Array("/foobar"))
void sendByteArray(@RequestBody Request request, OutputStream os) {
  os.write(byteArray);
  os.flush(); // not sure
  doLengthyCleanup(); 
}

@Async
void doLengthyCleanup() {
  // this will be executed asynchronously
}