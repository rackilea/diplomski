ByteBuffer reUsableBuffer = ByteBuffer.allocateDirect(5120);
Selector selector = Selector.open();
ServerSocketChannel channel = .. // wherever you get it from 
channel.register(selector, SelectionKey.OP_ACCEPT);
Executor executor = Executors.newThreadPoolExecutor();
while(selector.isOpen()) { 
 int numKey = selector.select();
 for (SelectionKey key: selector.selectedKeys()) {
    if (key.isAcceptable()) {
             /// Sort of included for completeness but you get the idea
           ServerSocketChannel server = (ServerSocketChannel)key.channel();
           SocketChannel channel = server.accept();
           channel.register(selector, SelectionKey.OP_READ | Selection.OP_WRITE, new StringBuilder());
    }    if (key.isReadable()) {
          // READ the data
          reUsableBuffer.clear();
          // You have to keep track of previous state.
          // NIO makes no guarantees of anything
          StringBuilder builder = key.attachment();
          SocketChannel socketChannel = (SocketChannel)key.channel();
          int readCount = socketChannel.read(reUsableBuffer);
          if (readCount > 0) {
             reUsableBuffer.flip();
             byte[] subStringBytes = new byte[readCount];
             reUsableBuffer.read(subStringBytes);
             // Assuming ASCII (bad assumption but simplifies the example)
             builder.append(new String(substringBytes));

             Command[] commands = removeCommands(builder);
             // Deal with your commands in some async manor defined by you
             executor.execute(new Task(commands));
          }
        }
        selector.selectedKeys().clear(); } ....

    }   

//
// Parse out the commands and return them, also remove traces of them in the
// the builder, such that for a string, "COMMAND, COMMAND, COM"
// an array of 2 should be returned with a left over buffer of "COM"
public Command[] parseCommands(StringBuilder s) { ... }