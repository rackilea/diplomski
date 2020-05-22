final JBBPParser tcpParser = JBBPParser.prepare(
          "skip:34; // skip bytes till the frame\n"
          + "ushort SourcePort;"
          + "ushort DestinationPort;"
          + "int SequenceNumber;"
          + "int AcknowledgementNumber;"

          + "bit:1 NONCE;"
          + "bit:3 RESERVED;"
          + "bit:4 HLEN;"

          + "bit:1 FIN;"
          + "bit:1 SYN;"
          + "bit:1 RST;"
          + "bit:1 PSH;"
          + "bit:1 ACK;"
          + "bit:1 URG;"
          + "bit:1 ECNECHO;"
          + "bit:1 CWR;"

          + "ushort WindowSize;"
          + "ushort TCPCheckSum;"
          + "ushort UrgentPointer;"
          + "byte [$$-34-HLEN*4] Option;"
          + "byte [_] Data;"
  );

final JBBPFieldStruct result = pngParser.parse(tcpFrameStream);