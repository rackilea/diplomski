public class HeaderFieldEncoder extends MessageToByteEncoder<ByteBuf> { 
      public HeaderFieldEncoder(String header){
         this.header = header;
      }     
      @Override
      protected void encode(
         ChannelHandlerContext ctx,
         ByteBuf msg,
         ByteBuf out
      )throws Exception {                           
         //header = "nChat v1.0"
         ByteBuf headerBuf = Unpooled.copiedBuffer(
            header.getBytes(charset));                                    
         out.writeBytes(headerBuf);
         out.writeBytes(msg, msg.readerIndex(), msg.readableBytes());      
      }           
   }


   public class HeaderFieldDecoder extends MessageToMessageDecoder<ByteBuf> {
      public HeaderFieldDecoder(String header){
         this.header = header;
      }
      @Override
      protected void decode(
         ChannelHandlerContext ctx,
         ByteBuf msg,
         List<Object> out
      )throws Exception {
         String extractedHeader = extractHeader(msg);
         //if desired, validate header
         //if(!header.equals(extractedHeader)
         String content = msg.toString(charset);
         out.add(content);         
      }

      private String extractHeader(ByteBuf msg){
         String headerField = null;
         if(msg.readableBytes() >= header.length()){
            byte[] headerBytes = new byte[header.length()];
            msg.readBytes(headerBytes, 0, header.length());
            headerField = new String(headerBytes, charset);
         }
         return headerField;
      }
   }