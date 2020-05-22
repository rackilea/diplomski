@Test
public void generateEntry() {
    ISOMsgZxc isoMsgZxc = new ISOMsgZxc();
    isoMsgZxc.setMti("0100");
    isoMsgZxc.setMid("0100");
    isoMsgZxc.setProcessingCode("000012");
    isoMsgZxc.setTransactionAmount("00.000");

    AbcEntry entry = txnService.generateEntry(isoMsgZxc);

    //verfiy
    verify(abcEntry).setEntryMid(isoMsgZxc.getMid());

    Map<String, String> expectedValues = new HashMap<>();
    expectedValues.put("0400.20", "R");
    expectedValues.put("0200.02", "R");
    //...

    expectedValues.forEach((input, output) -> verify(input).setEntryType(output));
}