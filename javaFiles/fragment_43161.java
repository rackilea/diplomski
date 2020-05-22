226     private void decodeAuto(Context ctx, IoSession session, IoBuffer in, ProtocolDecoderOutput out)
227             throws CharacterCodingException, ProtocolDecoderException {
228         int matchCount = ctx.getMatchCount();
229 
230         // Try to find a match
231         int oldPos = in.position();
232         int oldLimit = in.limit();
233 
234         while (in.hasRemaining()) {
235             byte b = in.get();
236             boolean matched = false;
237 
238             switch (b) {
239             case '\r':
240                 // Might be Mac, but we don't auto-detect Mac EOL
241                 // to avoid confusion.
242                 matchCount++;
243                 break;
244 
245             case '\n':
246                 // UNIX
247                 matchCount++;
248                 matched = true;
249                 break;
250 
251             default:
252                 matchCount = 0;
253             }
254 
255             if (matched) {
256                 // Found a match.
257                 int pos = in.position();
258                 in.limit(pos);
259                 in.position(oldPos);
260 
261                 ctx.append(in);
262 
263                 in.limit(oldLimit);
264                 in.position(pos);
265 
266                 if (ctx.getOverflowPosition() == 0) {
267                     IoBuffer buf = ctx.getBuffer();
268                     buf.flip();
269                     buf.limit(buf.limit() - matchCount);
270 
271                     try {
272                         byte[] data = new byte[buf.limit()];
273                         buf.get(data);
274                         CharsetDecoder decoder = ctx.getDecoder();
275 
276                         CharBuffer buffer = decoder.decode(ByteBuffer.wrap(data));
277                         String str = new String(buffer.array());
278                         writeText(session, str, out);
279                     } finally {
280                         buf.clear();
281                     }
282                 } else {
283                     int overflowPosition = ctx.getOverflowPosition();
284                     ctx.reset();
285                     throw new RecoverableProtocolDecoderException("Line is too long: " + overflowPosition);
286                 }
287 
288                 oldPos = pos;
289                 matchCount = 0;
290             }
291         }
292 
293         // Put remainder to buf.
294         in.position(oldPos);
295         ctx.append(in);
296 
297         ctx.setMatchCount(matchCount);
298     }