// Format of data under first SMS TPDU TLV, taken using EnvelopeHandler.findTLV()
// ----------+-----+---------+---------+--------+--------+---------+--------+-------+
//     1     |  1  |     1   |  0~10   |    1   |   1    |    7    |   1    | 0~140 |
// ----------+-----+---------+---------+--------+--------+---------+--------+-------+
//           | Len | TON/NPI | Address |        |        |         |        |       |
// TP-MTI... |        TP-OA            | TP-PID | TP-DCS | TP-SCTS | TP-UDL | TP-UD |
// ----------+-----+---------+---------+--------+--------+---------+--------+-------+

// Get received TPOA
EnvelopeHandler envHdlr = EnvelopeHandler.getTheHandler();
envHdlr.findTLV(ToolkitConstants.TAG_SMS_TPDU, (byte) 1);

// Assign TPOA to a buffer [0] for bytes-length [1..12] for the value as coded in 3GPP TS 23.040
envHdlr.copyValue((short) 1, tpdaBuf, (short) 1, (short) 12);
byte lengthTPOA = (byte) ((tpdaBuf[1] + 5) / 2);
tpdaBuf[0] = lengthTPOA;