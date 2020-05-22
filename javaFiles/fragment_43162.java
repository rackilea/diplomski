180     public void decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
181         Context ctx = getContext(session);
182 
183         if (LineDelimiter.AUTO.equals(delimiter)) {
184             decodeAuto(ctx, session, in, out);
185         } else {
186             decodeNormal(ctx, session, in, out);
187         }
188     }