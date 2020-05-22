int byteCount = 0;
int skipMark = 5;
while ((ch = isr.read()) != -1) {
   if(byteCount < skipMark)
      skipBuffer.append(ch);
   else
      sb.append((char) ch);
   byteCount++;
}