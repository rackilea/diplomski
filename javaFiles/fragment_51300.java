public class MyDecoder implements MessageDecoder {
      public MessageDecoderResult decode(IoSession session, IoBuffer buffer, ProtocolDecoderOutput decoderOutput) throws Exception {
           /* Your
              decode
              mechanism */
           decoderOutput.write(message); // don't forget to write your decoded message object at some point.
           return MessageDecoder.OK; //or something else that matches your needs.
      }
}